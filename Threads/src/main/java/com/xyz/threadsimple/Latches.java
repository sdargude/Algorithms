package com.xyz.threadsimple;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class  LatchProcessor implements Runnable {
    private CountDownLatch latch;

    public LatchProcessor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(" Started ");
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}

public class Latches {
    public static void main(String [] args ) {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=0; i<3; i++) {
            executor.submit(new LatchProcessor(latch));
        }

        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("Completed...");
    }
}
