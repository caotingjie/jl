package com.ctj.controllers.user;

import com.ctj.pojos.user.User;
import com.ctj.services.UserService;
import com.ctj.util.JacksonUtil;
import com.ctj.util.ParseMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getLoginJsp.do")
    public String userLogin(){
        return "user/login";
    }

    @RequestMapping("/userLogin.do")
    @ResponseBody
    public String userLogin(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String result = null;
        Map<String,Object> map = new HashMap<String,Object>();
        User user = userService.getUserByUserName(userName);
        if(user != null){
            String md5Password = ParseMD5.parseStrToMd5L32(password);
            if(md5Password.equals(user.getPassword())){
                request.getSession().setAttribute("user",user);
                map.put("flag","success");
            }else {
                map.put("flag","failed");
                map.put("msg","用户名或者密码错误！");
                result = JacksonUtil.mapToJson(map);
                return result;
            }
        }

        return null;
    }

    @RequestMapping("/test.do")
    @ResponseBody
    public String test(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("flag","failed");
        map.put("msg","用户名或者密码错误！");
        String result = JacksonUtil.mapToJson(map);
        return result;
    }
}
