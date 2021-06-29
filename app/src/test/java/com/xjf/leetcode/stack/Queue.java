package com.xjf.leetcode.stack;

import java.util.Stack;

/**
 * Description:通过栈实现队列
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/29/21 12:13 PM
 */
class Queue<E> implements IQueue<E> {
    private Stack<E> inStack;
    private Stack<E> outStack;


    public Queue() {
        inStack = new Stack();
        outStack = new Stack();
    }

    @Override
    public void offer(E e) {
        inStack.push(e);
    }

    @Override
    public E poll() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    @Override
    public E peek() {
        return outStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}


