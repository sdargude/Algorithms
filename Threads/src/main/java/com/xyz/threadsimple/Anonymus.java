package com.xyz.threadsimple;

public class Anonymus {
    public static void main(String [] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i= 0; i<10;i++) {
                    System.out.println("Hello " + i);
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e) {

                    }
                }
            }
        });
        t1.start();
    }
}
