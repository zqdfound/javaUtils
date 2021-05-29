package com.common.designPattern.adapter;

/**
 * 适配器模式
 *
 * @author zhuangqingdian
 * @date 2021/5/14
 */
public class AdapterMode {
    //将一个类的接口转化为客户期望的接口，Adapter模式使得原本由于接口不兼容而不能一起工作的类可以一起gongzuo
    //    目标接口（Target）：客户所期待的接口。目标可以是具体的或抽象的类，也可以是接口。
    //    需要适配的类（AdapterClass）：需要适配的类或适配者类。
    //    适配器（Adapter）：通过包装一个需要适配的对象，把原接口转换成目标接口。

    class AdapterClass{
        public void request(){
            System.out.println("request");
        }
    }

    interface Target{
        void hadleTarget();
    }

    class Adapter extends AdapterClass implements Target{
        @Override
        public void hadleTarget() {
            super.request();
        }
    }

}
