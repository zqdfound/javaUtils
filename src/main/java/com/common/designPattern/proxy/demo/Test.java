package com.common.designPattern.proxy.demo;

/**
 * @author zhuangqingdian
 * @date 2021/5/29
 */
public class Test {
    @org.junit.Test
    public void test01(){
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.doRequest();
    }
}
