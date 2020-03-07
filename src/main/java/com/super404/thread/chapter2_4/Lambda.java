package com.super404.thread.chapter2_4;

/**
 * Lambda表达式方式创建线程
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
