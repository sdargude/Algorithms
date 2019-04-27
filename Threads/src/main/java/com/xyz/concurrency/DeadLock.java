package com.xyz.concurrency;

class A {
    A() {
        System.out.println("A Created!");
    }
}

class B {
    B() {
        System.out.println("B Created!");
    }
}

class ThreadA implements Runnable {
    A a;
    B b;

    ThreadA(A a, B b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        synchronized (a) {
            try {
                System.out.println("Locked on A");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (b) {
                System.out.println("Locked on B");
            }
        }
    }
}


class ThreadB implements Runnable {
    A a;
    B b;

    ThreadB(A a, B b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        synchronized (b) {
            System.out.println("Locked on B");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (a) {
                System.out.println("Locked on A");
            }
        }
    }
}


public class DeadLock {
    public static void main(String [] args) {
        A a = new A();
        B b = new B();

        Thread ta = new Thread (new ThreadA(a,b));
        Thread tb = new Thread (new ThreadB(a,b));

        ta.start();
        tb.start();
    }
}