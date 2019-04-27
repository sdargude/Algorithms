package com.xyz.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

class PrintJob implements Runnable {

    private int Jobid;
    Printer printer;

    PrintJob(int Jobid, Printer printer) {
        this.Jobid = Jobid;
        this.printer = printer;
    }

    public void run() {
        try {
            System.out.println("Printing Job " + Jobid);
            printer.print(Jobid);
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Printer {
    private Semaphore sem;



    Printer() {
        sem = new Semaphore(1);
    }

    void print(int Jobid) {

        try {
            sem.acquire();
            System.out.println("Printing Job " + Jobid );
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Jobid + " Job done!");
            sem.release();
        }

    }

}



public class BinarySemaphore {

    public static void main(String [] args) {
        Printer printer = new Printer();
        ThreadPoolExecutor te = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i<100; i++) {
            te.submit(new PrintJob(i,printer));
        }

        te.shutdown();
    }
}
