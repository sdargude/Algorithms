package com.xyz.concurrency;

class Mythread extends  Thread {
    public void run() {
        System.out.println("Hello World "+ this.getId());
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End World "+ this.getId());

    }
}

public class ExtendThread {
    public static void main(String [] str){
        Mythread mythread1 = new Mythread();
        Mythread mythread2 = new Mythread();
        Mythread mythread3 = new Mythread();
        Mythread mythread4 = new Mythread();

        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread4.start();
    }
}
