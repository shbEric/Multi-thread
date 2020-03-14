package com.super404.atomic.chapter6_3;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray Demo
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        System.out.println(atomicIntegerArray.addAndGet(1,8));

        int i = atomicIntegerArray.accumulateAndGet(0, 2, (left, right) -> left > right ? left : right);
        System.out.println(i);
    }
}
