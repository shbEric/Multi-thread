package com.super404.pool.chapter9_5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> runnableLinkedBlockingQueue = new LinkedBlockingQueue<>(20);
        /*for (int i = 0; i < 100; i++) {
            runnableLinkedBlockingQueue.put(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }*/

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,
                3L, TimeUnit.SECONDS,runnableLinkedBlockingQueue,new CustomPolicy());
        /*通过new创建线程池时，除非调用prestartAllCoreThreads方法初始化核心线程，
        否则此时线程池中有0个线程，即使工作队列中存在多个任务，同样不会执行*/
        threadPoolExecutor.prestartAllCoreThreads();
        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadPoolExecutor.getActiveCount());
            });
        }

        /*Future<String> submit = null;
        for (int i = 0; i < 100; i++) {
            submit = threadPoolExecutor.submit(new CallableDemo());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(submit.get());
        }*/
    }
}
