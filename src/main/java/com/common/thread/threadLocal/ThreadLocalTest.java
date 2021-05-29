package com.common.thread.threadLocal;

/**
 * @author zhuangqingdian
 * @date 2021/5/14
 */
public class ThreadLocalTest {
    /*ThreadLocal是JDK包提供的，它提供线程本地变量，
    如果创建一个ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的一个副本，
    在实际多线程操作的时候，操作的是自己本地内存中的变量，从而规避了线程安全问题*/
    static ThreadLocal<String> localStr = new ThreadLocal<>();
    static void get(String str){
        //打印当前线程的副本变量值
        System.out.println(str+":"+localStr.get());
        localStr.remove();
    }

    public static void main(String[] args) {
        new Thread(()->{
            //设置当前线程副本值
            localStr.set("localStr1");
            get("Thread1");
            System.out.println("after remove:"+localStr.get());
        }).start();
        new Thread(()->{
            //设置当前线程副本值
            localStr.set("localStr2");
            get("Thread2");
            System.out.println("after remove:"+localStr.get());
        }).start();
    }

}
