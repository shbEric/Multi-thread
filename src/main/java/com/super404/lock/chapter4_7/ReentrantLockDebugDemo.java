package com.super404.lock.chapter4_7;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDebugDemo {
    private int i = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void inCreate(){
        reentrantLock.lock();
        try{
            i++;
            System.out.println(i);
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDebugDemo reentrantLockDebugDemo = new ReentrantLockDebugDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                reentrantLockDebugDemo.inCreate();
            }).start();
        }
    }
}
