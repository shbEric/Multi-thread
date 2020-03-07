package com.super404.thread.chapter2_8;

public class DaemonThreadDemo implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThreadDemo());
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000L);

    }
}
