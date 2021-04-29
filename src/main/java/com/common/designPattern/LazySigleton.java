package com.common.designPattern;

/**
 * 懒汉单例模式
 * @author zhuangqingdian
 * @date 2021/4/29
 */
public class LazySigleton {
    private static LazySigleton lazySigleton;
    private LazySigleton(){};
    public static LazySigleton getInstance(){
        if(lazySigleton == null){
            return new LazySigleton();
        }
        return lazySigleton;
    }
}
