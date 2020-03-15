package com.super404.container.chapter7_3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add("demo" + i);
        }

        //遍历可以
        /*strings.forEach(e->{
            if (e.equals("demo2")){
                strings.remove(e);
                System.out.println(e);
            }
        });*/

        //迭代不支持移除相应的元素
        /*Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()){
            String next = stringIterator.next();
            if (next.equals("demo2")){
                stringIterator.remove();
                System.out.println(next);
            }
        }*/

        //多线程遍历可以
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                strings.forEach(e->{
                    if (e.equals("demo2")){
                        strings.remove(e);
                        System.out.println(e);
                    }
                });
            }).start();
        }
    }
}
