package com.ctj.proxyTest;


/**
 * Created by AJie on 2016/6/11.
 */
public class ProxyTest {

    public void testProxy(){
        ProxyFactory proxyFactory = new ProxyFactory();
        UserService userService = (UserService)proxyFactory.createProxyBean(new UserServiceBean("xiaoming"));
        userService.save();
    }
}
