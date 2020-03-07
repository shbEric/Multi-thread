package com.super404.thread.chapter2_7;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
                /*try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }, "线程1");

        Thread thread2 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
                /*try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }, "线程2");

        thread.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread.start();
        thread2.start();
    }
}
