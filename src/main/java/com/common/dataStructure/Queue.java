package com.common.dataStructure;

/**队列 数组实现
 * @author zhuangqingdian
 * @date 2021/4/28
 */
public class Queue<E> {

    private  int maxSize;
    //头
    private int head;
    //尾
    private int tail;

    private Object[] data = null;

    public Queue() {
        this(10);
    }

    public Queue(int initSize){
        if(initSize > 0){
            this.maxSize = initSize;
            head = 0;
            tail = 0;
            data = new Object[initSize];
        }else{
            throw new RuntimeException("初始容量应大于0:"+initSize);
        }
    }
    //入队
    public boolean add(E e){
        if(head - tail == maxSize){
            throw new RuntimeException("队列已满,无法入队");
        }else{
            data[head++] = e;
            return true;
        }
    }
    //出队
    public E poll(){
        if(head - tail == 0){
            throw new RuntimeException("队列已空，无法出队");
        }else{
            return (E)data[tail++];
        }
    }
}
