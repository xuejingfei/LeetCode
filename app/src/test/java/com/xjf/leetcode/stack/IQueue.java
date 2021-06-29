package com.xjf.leetcode.stack;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/29/21 6:52 PM
 */
interface IQueue<E> {

    void offer(E e);// 队列中尾部添加原色

    E poll();//从队列中移除首部的元素

    E peek(); // 返回首部的元素

    boolean isEmpty();
}
