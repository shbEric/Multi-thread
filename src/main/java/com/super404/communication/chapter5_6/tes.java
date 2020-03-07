package com.super404.communication.chapter5_6;

import java.util.HashMap;

public class tes {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","123456\t");
        System.out.println(map.toString());
        System.out.println(map.get("1"));
    }
}
