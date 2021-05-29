package com.common.designPattern.proxy.demo;

/**代理主题（Proxy）角色：也叫做委托类、代理类，该角色负责控制对真实主题的引用，
 * 负责在需要的时候创建或删除真实主题对象，并且在真实主题角色处理完毕前后做预处理和善后处理工作
 * @author zhuangqingdian
 * @date 2021/5/29
 */
public class Proxy implements Subject{

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void doRequest() {
        doBefore();
        subject.doRequest();
        doAfter();
    }

    private void doBefore() {
        System.out.println("do before");
    }

    private void doAfter() {
        System.out.println("do after");
    }
}
