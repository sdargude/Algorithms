package com.xyz.concurrency;



public class SynchronizedBasic1 {

    private int count = 0;

    synchronized void  increment (){
        count++;
    }

    public void dowork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e) {}

    }

    public static void main(String args[]) {
        SynchronizedBasic1 s = new SynchronizedBasic1();
        s.dowork();
        System.out.println(s.count);

    }
}
