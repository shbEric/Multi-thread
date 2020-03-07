package com.super404.thread.chapter2_4;


/**
 * 匿名内部类方式创建线程
 */
public class MyThread {
    public static void main(String[] args) {
        //匿名内部类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
    }

}
