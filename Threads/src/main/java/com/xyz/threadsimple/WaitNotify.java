package com.xyz.threadsimple;

import java.util.LinkedList;

class WNprocessor{
    private LinkedList <Integer> list = new LinkedList<>();
    private final int LIMIT=10;
    private Object lock = new Object();

    public void producer() throws InterruptedException{
        int value = 0;

        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                System.out.println("Producer : List size is " + list.size());
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consumer () throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.isEmpty()) {
                    lock.wait();
                }
                System.out.print("Consumer : List size is " + list.size());
                int value = list.removeFirst();
                System.out.println("; Value is " + value);
                Thread.sleep(1000);
                lock.notify();
            }
        }
    }
}



public class WaitNotify {
    public static void main(String [] args) throws InterruptedException {
        WNprocessor p = new WNprocessor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
