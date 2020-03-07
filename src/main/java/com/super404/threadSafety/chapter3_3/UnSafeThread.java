package com.super404.threadSafety.chapter3_3;

import java.util.concurrent.CountDownLatch;

/**
 * 线程不安全demo
 */
public class UnSafeThread {

    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    //synchronize关键字，使得操作具有原子性
    public static synchronized void inCreate(){
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()-> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //每个线程执行完成之后，调用countdownLatch
                countDownLatch.countDown();
            }).start();
        }
        while (true){
            if (countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }
    }
}
