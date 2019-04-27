package com.xyz.threadsimple;

import java.util.concurrent.TimeUnit;

public class HelloRunnable implements  Runnable {

    @Override
    public void run() {
        System.out.println("Hello World ");
        for (int i = 0 ; i<10; i ++){
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
              //  Thread.sleep(100);
            } catch (Exception s) {
                System.out.println(s);
            }
        }
    }

    public static void main(String [] args) {
        Runnable hr = new HelloRunnable();
        Runnable hr1 = new HelloRunnable();
        Thread t1 = new Thread(hr1);
        Thread t2 = new Thread(hr);
        t1.start();
        t2.start();
        System.out.println("This is main Program");
        try {
            Thread.currentThread().join(1);
        }catch (Exception e) {
            System.out.println("Out");
        }

        System.out.println("This is After Join.");
    }
}
