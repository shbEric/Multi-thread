package com.super404.lock.chapter4_12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级
 */
public class LockDegrade {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();

        writeLock.lock();
        readLock.lock();
        writeLock.unlock();
        readLock.unlock();

        System.out.println("程序运行结束");

    }
}
