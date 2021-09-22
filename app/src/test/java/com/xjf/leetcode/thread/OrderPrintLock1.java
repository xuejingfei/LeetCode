package com.xjf.leetcode.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/15 18:37
 */
class OrderPrintLock1 {
    private CountDownLatch a = new CountDownLatch(1);
    private CountDownLatch b = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        a.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        a.await();
        printSecond.run();
        b.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        b.await();
        printThird.run();
    }
}
