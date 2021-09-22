package com.xjf.leetcode.thread;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/15 17:43
 */
class OrderPrintLock {

    private volatile int variable=0;

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        variable ++ ;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true) {
            if(variable == 1) break;
        }
        printSecond.run();
        variable ++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(true) {
            if(variable == 2) break;
        }
        printThird.run();
        variable ++;
    }
}
