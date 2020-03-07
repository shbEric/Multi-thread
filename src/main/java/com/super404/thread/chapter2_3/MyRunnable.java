package com.super404.thread.chapter2_3;


import java.io.IOException;

/**
 * 实现Runnable接口方式创建线程
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("super404");
        //调用start()，启动一个新的线程，所以输出super404
        //所以要创建一个线程，一定要调用start()
        thread.start();

        //调用run()，不启动一个线程，所以还在主线程中执行，直接调用类里的run方法，输出main
        //thread.run();
    }
}
