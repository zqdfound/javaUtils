package com.common.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理模式 jdk动态代理
 * @author zhuangqingdian
 * @date 2021/5/14
 */
public class ProxyHandler implements InvocationHandler {

    private Person person;

    public ProxyHandler(Person person){
       this.person = person;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        System.out.println("one person was born in the nasty world");
        if(method.getName().equals("live")){
            o = method.invoke(person,args);
        }
        System.out.println("one person was left this awful world");
        return o;
    }

}
