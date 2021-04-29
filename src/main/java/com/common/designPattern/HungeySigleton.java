package com.common.designPattern;

/**
 * 饿汉单例模式
 * @author zhuangqingdian
 * @date 2021/4/29
 */
public class HungeySigleton {
    //饿汉模式下，在类加载时，实例便已经存在在JVM中
    private static HungeySigleton hungeySigleton = new HungeySigleton();
    private HungeySigleton(){};
    public HungeySigleton getInstance(){
        return hungeySigleton;
    }
}
