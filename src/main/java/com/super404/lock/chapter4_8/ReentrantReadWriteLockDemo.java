package com.super404.lock.chapter4_8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private int i = 0;
    private int j = 0;

    private ReadWriteLock lock= new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void out(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "i的值=====》" + i + "j的值====》" + j);
        } finally {
            readLock.unlock();
        }

    }

    public void inCreate(){
        writeLock.lock();
        try {
            i++;
            Thread.sleep(500L);
            j++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                reentrantReadWriteLockDemo.inCreate();
                reentrantReadWriteLockDemo.out();
            }).start();
        }
    }
}
