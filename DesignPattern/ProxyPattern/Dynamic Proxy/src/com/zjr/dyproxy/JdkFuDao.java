package com.zjr.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* 动态代理类 实现InvocationHandler */
public class JdkFuDao implements InvocationHandler {
    /* 存储真实对象 */
    private IPerson target;

    /* 传入真实对象 */
    public IPerson getInstance(IPerson target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /* 接口方法中使用真实对象的方法，并增强 */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        before();
        Object result = method.invoke(this.target, args);
        after();

        return result;
    }

    private void after() {
        System.out.println("双方同意，开始辅导");
    }

    private void before() {
        System.out.println("这里是C语言中文网辅导班，已经收集到您的需求，开始挑选老师");
    }
}
