package com.xjf.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/15 19:48
 */
class OrderPrintLock2 {
    private AtomicInteger atomic = new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        atomic.incrementAndGet();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true) {
            if(atomic.get() == 1) break;
        }
        printSecond.run();
        atomic.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(true) {
            if(atomic.get() == 2) break;
        }
        printThird.run();
    }

}
