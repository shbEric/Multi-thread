package com.super404.thread.chapter2_5;

/**
 * suspend死锁演示
 */
public class DeadDemo implements Runnable {

    private static Object object = new Object();

    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"占用资源");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName()+"释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeadDemo(), "对比线程");
        thread.start();
        Thread.sleep(3000L);
        thread.resume();

        Thread thread1 = new Thread(new DeadDemo(), "死锁线程");
        thread1.start();
        /*造成thread1线程死锁的原因是：
        thread1需要等待获得object锁才能执行suspend()，
        在等待的过程中thread1.resume()有可能先被执行了，
        thread1.resume()发生在suspend()之前，thread1被永久挂起了。
        DeadDemo1.class中的例子更直观*/
        thread1.resume();
    }
}
