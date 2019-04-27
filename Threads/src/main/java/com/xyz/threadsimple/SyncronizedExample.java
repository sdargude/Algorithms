package com.xyz.threadsimple;

public class SyncronizedExample {

    private int count = 0;

    public static void main(String[] args) {
        SyncronizedExample s1 = new SyncronizedExample();
        s1.dowork();
    }

    public synchronized void increment() {
        count++;
    }

    public void dowork (){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100000; i++) {
                   increment();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
        }

        System.out.println("Count is: "+count);
    }
}
