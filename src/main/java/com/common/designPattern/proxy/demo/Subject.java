package com.common.designPattern.proxy.demo;

/**
 * 抽象主题（Subject）角色：该角色是真实主题和代理主题的共同接口，以便在任何可以使用真实主题的地方都可以使用代理主题
 * @author zhuangqingdian
 * @date 2021/5/29
 */
public interface Subject {
    void doRequest();
}
