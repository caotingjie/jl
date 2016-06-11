package com.ctj.controllers;

import com.ctj.pojos.User;
import com.ctj.services.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by tingjie.cao on 2016/5/7.
 */
@Controller
public class UserController {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/getUserList.do")
    public ModelAndView getUserList(){
        SqlSession session = sqlSessionFactory.openSession();
        UserService userService = session.getMapper(UserService.class);
        List<User> list = userService.getUserList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("test",list);
        return modelAndView;
    }
}
