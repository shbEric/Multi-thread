package com.super404.pool.chapter9_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟OOM
 */
public class OOMDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
