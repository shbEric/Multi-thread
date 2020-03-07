package com.super404.thread.chapter2_2;

import java.io.IOException;

public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {

        /*//Runnable状态
        Thread thread = new Thread(()->{
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();*/

        /*//TIME_WAITING状态
        Object object = new Object();
        Thread thread = new Thread(()->{
            synchronized (object){
                try {
                    Thread.sleep(10000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(2000L);

        //BLOCKED状态
        Thread thread2 = new Thread(()->{
            synchronized (object){
            }
        });
        thread2.start();*/

        /*//WAITING状态
        Object object = new Object();
        Thread thread = new Thread(()->{
            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();*/


    }
}
