package com.common.dataStructure;

/**
 * 双向链表
 *
 * @author zhuangqingdian
 * @date 2021/4/28
 */
public class TwoWayLinkedList {
    //头节点
    private Node head;
    //尾节点
    private Node tail;

    private int length;

    public TwoWayLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    private class Node {
        private Node next;
        private Node prev;
        private Object data;

        public Node(Object o) {
            this.data = o;
        }
    }

    //添加节点
    public void addNode(Object o){
        Node node = new Node(o);
        if(length == 0){
            head = node;
            tail = node;
            length++;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
            length++;
        }
    }
    //根据元素删除节点
    public boolean deleteByData(Object o){
        if(length == 0){
            System.out.println("空链表");
            return false;
        }
        int index = 0;
        Node node = head;
        while(index < length){
            if(node.data.equals(o)){
                if(length == 1){
                    this.length = 0;
                    this.head = null;
                    this.tail = null;
                }else{
                    if(node == head){
                        //删除的是头节点
                        head = node.next;
                    }else if(node == tail){
                        //删除的是尾节点
                        tail = node.prev;
                    }else{
                        Node preNode = node.prev;
                        Node nextNode = node.next;
                        preNode.next = nextNode;
                        nextNode.prev = preNode;
                    }

                    length--;
                }
            }
            index++;
            node = node.next;
        }
        return true;
    }

    //打印
    public String printList(){
        int i = 0;
        String result = "";
        Node node = head;
        while (i < length){
            result  += node.data + " ";
            node = node.next;
            i++;
        }
        return result;
    }

    public int getLength(){
        return this.length;
    }

}
