package com.ctj.proxyTest;

/**
 * Created by AJie on 2016/6/11.
 */
public class UserServiceBean implements UserService{
    private String userName = null;

    public String getUserName() {
        return userName;
    }

    public UserServiceBean(){}
    public UserServiceBean(String userName) {
        this.userName = userName;
    }

    public void save() {
        System.out.printf("调用save()方法");
    }
}
