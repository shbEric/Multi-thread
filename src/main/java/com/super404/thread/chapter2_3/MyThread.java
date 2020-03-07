package com.super404.thread.chapter2_3;

/**
 * 继承Thread类方式创建线程
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("线程demo");
        myThread.start();
    }
}
