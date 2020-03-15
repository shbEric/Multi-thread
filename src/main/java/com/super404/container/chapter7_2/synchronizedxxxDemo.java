package com.super404.container.chapter7_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class synchronizedxxxDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(strings);
    }
}
