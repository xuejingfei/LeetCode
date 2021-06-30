package com.xjf.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/30/21 10:10 AM
 */
class StackByOneQueue<E> implements IStack<E>{
    private Queue<E> queue;

    public StackByOneQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        queue.add(e);
    }

    @Override
    public E pop() {
        int size = queue.size();
        while(size-1>0) {
            this.push(queue.poll());
            size--;
        }
        return queue.poll();
    }

    @Override
    public E top() {
        if(!queue.isEmpty()) {
            E top = pop();
            push(top);
            return top;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
