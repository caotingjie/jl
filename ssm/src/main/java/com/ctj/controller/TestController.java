package com.ctj.controller;

import com.ctj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author caotingjie
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping("/haha")
    public void test(){
        System.out.println(userService.getUserNameById(1));
    }
}
