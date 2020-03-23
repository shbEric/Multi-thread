package com.super404.pool.chapter9_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> runnableLinkedBlockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,
                                                3L, TimeUnit.SECONDS,runnableLinkedBlockingQueue);

        Future<String> submit = null;
        for (int i = 0; i < 100; i++) {
            submit = threadPoolExecutor.submit(new CallableDemo());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(submit.get());
        }
    }
}
