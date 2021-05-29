package com.common.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhuangqingdian
 * @date 2021/4/22
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = 0;
                while (i < 4){
                    Thread.sleep(1000);
                    i++;
                    System.out.println(i);
                }
                return i;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        Thread t = new Thread(futureTask);
        t.start();

        System.out.println("开始计算。。");
        //get方法会阻塞
        int num = futureTask.get();

        System.out.println("计算结束...");

    }



}
