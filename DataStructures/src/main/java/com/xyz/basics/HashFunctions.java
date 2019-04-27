package com.xyz.basics;

import java.util.HashMap;

public class HashFunctions {

    static final int hash(int key) {

        return key ^ key >>> 16;
    }

    public static void main(String [] args ) {
        System.out.println(hash(17));
        int num = 8;
        System.out.println(num>>>16);
        System.out.println(num<<1);

        String s = "hello world";
        System.out.println(s.hashCode());

        HashMap<Integer, String> h = new HashMap<>();
    }
}
