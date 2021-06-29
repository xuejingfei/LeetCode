package com.xjf.leetcode.queue;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/29/21 5:45 PM
 */
interface IStack<E> {
    void push(E e);
    E pop();
    E top();
    boolean isEmpty();
}
