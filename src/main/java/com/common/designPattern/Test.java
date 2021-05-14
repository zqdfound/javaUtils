package com.common.designPattern;

import com.common.designPattern.proxy.Me;
import com.common.designPattern.proxy.Person;
import com.common.designPattern.proxy.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * @author zhuangqingdian
 * @date 2021/5/14
 */
public class Test {

    public static void main(String[] args) {
        //jdk动态代理
        Person p = new Me();
        ProxyHandler handler = new ProxyHandler(p);
        Person instance = (Person) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Person.class},handler);
        instance.live();
    }
}
