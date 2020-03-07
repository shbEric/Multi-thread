package com.super404.thread.chapter2_6;


public class MyInterruptDemo implements Runnable {

    //需要volatile
    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyInterruptDemo());
        thread.start();
        Thread.sleep(1000L);
        FLAG = false;

    }
}
