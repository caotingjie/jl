package com.ctj.controllers.user;

import com.ctj.pojos.user.User;
import com.ctj.services.UserService;
import com.ctj.util.ParseMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView userLogin(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        ModelAndView mv = new ModelAndView();

        User user = userService.getUserByUserName(userName);
        if(user != null){
            String md5Password = ParseMD5.parseStrToMd5L32(password);
            if(md5Password.equals(user.getPassword())){
                mv.setViewName("/welcome");
               return mv;
            }else {

            }
        }

        return null;
    }
}
