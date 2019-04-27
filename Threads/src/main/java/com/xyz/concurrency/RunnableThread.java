package com.xyz.concurrency;

class MyThread implements Runnable {


    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("Hello Thread " + t.getId());
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End Thread " + t.getId());
    }
}

public class RunnableThread {
    public static void main(String args[]) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        Thread t1 = new Thread (m1);
        Thread t2 = new Thread (m2);

        t1.start();
        t2.start();
    }
}
