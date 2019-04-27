package com.xyz.threadsimple;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World " + this.getId());
        System.out.println("Thread id " + Thread.currentThread().getId());
    }

    public static void main(String[] args){

        HelloThread t = new HelloThread();
        HelloThread t2 = new HelloThread();
        t.start();
        t2.start();
        System.out.println("Main " + Thread.currentThread().getId());

    }
}
