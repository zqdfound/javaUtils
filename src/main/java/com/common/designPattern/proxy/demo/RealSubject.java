package com.common.designPattern.proxy.demo;

/**
 *
 * 真实主题（Real Subject）角色：该角色也叫做被委托角色、被代理角色，是业务逻辑的具体执行者。
 * @author zhuangqingdian
 * @date 2021/5/29
 */
public class RealSubject implements Subject{

    @Override
    public void doRequest() {
        System.out.println("doing request");
    }
}
