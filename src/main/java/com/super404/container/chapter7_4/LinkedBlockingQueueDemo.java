package com.super404.container.chapter7_4;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        //往队列存放元素
        strings.add("111");
        strings.offer("222");
        strings.put("333");

        //往队列中取元素
        String remove = strings.remove();
        strings.poll();
        strings.take();
    }
}
