package com.super404.threadSafety.chapter3_4;

public class SynDemo {

    public synchronized void out() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    public static synchronized void staticOut() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    private Object lock = new Object();
    public void myOut() throws InterruptedException {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000L);
        }
    }

    public static void main(String[] args) {
        SynDemo synDemo = new SynDemo();
        SynDemo synDemo1 = new SynDemo();

        new Thread(()->{
            try {
                //synDemo.out();
                //synDemo.staticOut();
                synDemo.myOut();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                //synDemo1.out();
                //synDemo1.staticOut();
                synDemo1.myOut();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
