package com.super404.threadSafety.chapter3_5;


public class VolatileDemo implements Runnable {

    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

    }
}
