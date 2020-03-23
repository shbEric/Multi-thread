package com.super404.pool.chapter9_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OOMDemo2 {
    public static void main(String[] args) {
        //会撑爆整个主机的内存
        ExecutorService executorService = Executors.newCachedThreadPool();
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
