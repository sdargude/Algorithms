package com.xyz.basics;

import java.util.HashMap;

public class Lru {

    int count = 0;
    HashMap<Integer, Entry> map;

    private class Entry {
        Entry next;
        Entry prev;
        int value;
        int key;
    }






}
