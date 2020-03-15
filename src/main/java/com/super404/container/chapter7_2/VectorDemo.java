package com.super404.container.chapter7_2;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("demo" + i);
        }

        //错误的遍历,forEach不能改动元素
        /*stringVector.forEach(e->{
            if (e.equals("demo3")){
                stringVector.remove(e);
            }
            System.out.println(e);
        });*/

        //正确迭代
        Iterator<String> stringIterator = stringVector.iterator();
        //单线程
        /*while (stringIterator.hasNext()){
            String next = stringIterator.next();
            if (next.equals("demo3")){
                stringIterator.remove();
                System.out.println(next);
            }
        }*/
        //多线程
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                synchronized (stringIterator){
                    while (stringIterator.hasNext()){
                        String next = stringIterator.next();
                        if (next.equals("demo3")){
                            stringIterator.remove();
                            System.out.println(next);
                        }
                    }
                }
            }).start();
        }


    }
}
