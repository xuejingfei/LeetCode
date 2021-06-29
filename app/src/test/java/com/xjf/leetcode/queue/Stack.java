package com.xjf.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:栈实现队列
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/29/21 12:14 PM
 */
class Stack<E> implements IStack<E>{
    private Queue<E> queue;
    private Queue<E> backupQueue;

    private Stack(){
        queue = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        backupQueue.add(e);
        while(!queue.isEmpty()) {
            backupQueue.offer(queue.poll());
        }

        Queue tem = queue;
        queue = backupQueue;
        backupQueue = tem;
    }


    @Override
    public E pop() {
        return queue.poll();
    }

    @Override
    public E top() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}






