package com.xjf.leetcode.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 读写锁:
 * 1.读读共享锁
 * 2.写读，写写，读写互斥
 * 3.
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date:7/23/21 6:29 PM
 */
class ReadWriteLock {
    private final Map<Thread, Integer> readingThreads = new HashMap<>();
    private int write;
    private int writeRequests;
    private Thread writeThread;

    /**
     * 开始读
     */
    public synchronized void lockRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (canReadAccess(callingThread)) {
            wait();
        }
        readingThreads.put(callingThread, getReadAccessCount(callingThread) + 1);
    }


    public synchronized void unlockRead() {
        Thread callingThread = Thread.currentThread();
        if (isReading(callingThread)) {
            throw new IllegalMonitorStateException("该线程并没有获得该实例的读锁");
        }
        int count = readingThreads.get(callingThread);
        if (count == 1) {
            readingThreads.remove(callingThread);
        } else {
            readingThreads.put(callingThread, count - 1);
        }
        notifyAll();
    }

    private boolean canReadAccess(Thread thread) {
        if (writeThread == thread) return true; //写读重入
        if (write > 0) return false; //写读互斥
        if (isReading(thread)) return true;//读读重入
        if (writeRequests > 0) return false;//写读互斥
        return true;
    }


    private int getReadAccessCount(Thread thread) {
        Integer count = readingThreads.get(thread);
        if (count == null) return 0;
        return count;
    }


    /**
     * 是否正在处于读
     */
    private boolean isReading(Thread thread) {
        return readingThreads.get(thread) != null;
    }


    public synchronized void lockWrite() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        writeRequests++;
        while (canWriteAccess(callingThread)) {
            wait();
        }
        writeRequests--;
        write++;
        writeThread = callingThread;
    }

    public synchronized void unLockWrite() {
        write--;
        if (write == 0) {
            writeThread = null;
        }
        notifyAll();
    }


    private boolean canWriteAccess(Thread thread) {
        if (readingThreads.size() == 1 && readingThreads.get(thread) !=null) return true;//读写重入
        if (readingThreads.size() > 0) return false; //读写互斥
        if (writeThread == null) return true;//写写互斥
        if (thread == writeThread) return true;//写写重入
        return false;
    }

}
