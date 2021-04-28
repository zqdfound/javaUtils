package com.common.dataStructure;

/** 栈 数组实现
 * @author zhuangqingdian
 * @date 2021/4/28
 */
public class Stack<E> {
    private Object[] data = null;

    private int maxSize = 0;

    private int top = -1;

    public Stack() {
        //缺省容量为10
        this(10);
    }

    public Stack(int initSize){
        if(initSize > 0){
            this.maxSize = initSize;
            data = new Object[initSize];
            top = -1;
        }else{
            throw new RuntimeException("初始大小不能小于0" +  initSize);
        }
    }
    //入栈
    public boolean push(E e){
        if(top == maxSize - 1){
            throw new RuntimeException("栈已满，无法入栈");
        }else{
            data[++top] = e;
            return true;
        }
    }
    //出栈
    public E pop(){
        if(top == -1){
            throw new RuntimeException("空栈，无法出栈");
        }else{
            return (E)data[top --];
        }
    }
}
