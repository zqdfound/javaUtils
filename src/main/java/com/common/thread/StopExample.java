package com.common.thread;

import org.junit.Test;

/**
 * @author zhuangqingdian
 * @date 2021/5/19
 */
public class StopExample {

    /*interrupt：
    如果线程处于正常活动状态，那么会将该线程的中断标志位设置为true，仅此而已。被设置中断标志的线程将继续正常运行，不受影响，后续i可以根据标志位做处理。
    如果线程处于被阻塞状态（比如Object.wait, Thread.sleep, Object.join），会不断地轮询监听中断标志位，发现其被设置为true后，会停止阻塞并抛出InterruptedException异常。在抛出异常后立即将线程的中断标志位清除，即重新设置为false。
    synchronized在获锁的过程中是不能被中断的，意思是说如果产生了死锁，则不能被中断。类似的，reentrantLock.lock()也是不可中断的。如果调用时被阻塞，则它一直阻塞到它获取到锁为止。
    如果调用带超时的reentrantLock.tryLock(long timeout, TimeUnit unit)或reentrantLock.lockInterruptibly()，那么线程在等待时被中断，将抛出一个InterruptedException异常，这是一个非常有用的特性，因为它允许程序打破死锁。
*/
    //中断非阻塞线程
    @Test
    public void stop()throws InterruptedException {
        Thread t = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("thread runing...");
                long time = System.currentTimeMillis();
                // 使用while循环模拟 sleep
                while ((System.currentTimeMillis() - time < 1000) ) {
                }
            }
            System.out.println("Thread exiting under request...");
        });

        System.out.println("start");
        t.start();
        Thread.sleep(3000);
        System.out.println("ask for stop");
        t.interrupt();
        Thread.sleep(3000);
        System.out.println("stopped");
    }

    //中断阻塞线程
    @Test
    public void stopBlock() throws InterruptedException {
        Thread t = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("thread runing...");
                try {
                    /*
                     * 如果线程阻塞，将不会去检查中断信号量stop变量，所 以thread.interrupt()
                     * 会使阻塞线程从阻塞的地方抛出异常，让阻塞线程从阻塞状态逃离出来，并
                     * 进行异常块进行 相应的处理
                     */
                    Thread.sleep(1000);// 线程阻塞，如果线程收到中断操作信号将抛出异常
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted...");
                    /*
                     * 如果线程在调用 Object.wait()方法，或者该类的 join() 、sleep()方法
                     * 过程中受阻，则其中断状态将被清除
                     */
                    System.out.println(Thread.currentThread().isInterrupted());// false

                    //中不中断由自己决定，如果需要真真中断线程，则需要重新设置中断位，如果
                    //不需要，则不用调用
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread exiting under request...");
        });

        System.out.println("Starting thread...");
        t.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        t.interrupt();// 等中断信号量设置后再调用
        Thread.sleep(3000);
        System.out.println("Stopping application...");

    }



}
