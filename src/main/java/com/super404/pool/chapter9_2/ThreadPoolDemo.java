package com.super404.pool.chapter9_2;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> runnableLinkedBlockingQueue = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,
                                                3L, TimeUnit.SECONDS,runnableLinkedBlockingQueue);

        for (int i = 0; i < 100; i++) {
            Future<?> future = threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
