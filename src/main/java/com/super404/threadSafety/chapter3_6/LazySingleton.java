package com.super404.threadSafety.chapter3_6;

/**
 * 懒汉式单例--最简单的写法是非线程安全的
 * 在需要的时候再实例化
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton(){
    }

    //非线程安全的
    /*public static LazySingleton getInstance(){
        //判断实例是否为空，为空则实例化
        if (null == lazySingleton){
            //模拟实例化时耗时的操作
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazySingleton = new LazySingleton();
        }
        //否则直接返回
        return lazySingleton;
    }*/

    //线程安全的，但是耗性能
    /*public static synchronized LazySingleton getInstance(){
        //判断实例是否为空，为空则实例化
        if (null == lazySingleton){
            //模拟实例化时耗时的操作
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazySingleton = new LazySingleton();
        }
        //否则直接返回
        return lazySingleton;
    }*/

    //double check 双重检测锁
    //但是因为jvm的指令重排序，还是有可能不是线程安全的
    //所以使用volatile关键字禁止指令重排序，保证线程安全性
    public static LazySingleton getInstance(){
        //判断实例是否为空，为空则实例化
        if (null == lazySingleton){
            //模拟实例化时耗时的操作
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(LazySingleton.class){
                if (null == lazySingleton){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        //否则直接返回
        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }
}
