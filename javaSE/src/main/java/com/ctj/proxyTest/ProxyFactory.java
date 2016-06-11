package com.ctj.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 需求 使用jdk动态代理对象 判断是不是有权限执行保存操作（判断是不是有用户名）
 * 如果要使用动态代理，被代理对象一定要实现接口，这也是jdk代理的弊端所在，不实现接口就不能使用jdk的动态代理
 *
 */
public class ProxyFactory implements InvocationHandler{
    private Object targetBean;

    public Object createProxyBean(Object targetBean){
        this.targetBean = targetBean;
        return Proxy.newProxyInstance(this.targetBean.getClass().getClassLoader(),this.targetBean.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        UserServiceBean userServiceBean = (UserServiceBean)this.targetBean;
        Object object = null;
        if(userServiceBean.getUserName() != null){//这个判断相当于判断权限
            /*
            * 动态代理只是在被代理对象的基础上添加一些功能
            * 比如说权限判断之类的，最终核心实现还是要由代理对象委托给被代理对象
            * */
            object = method.invoke(targetBean, args);
        }
        return object;
    }
}
