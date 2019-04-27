package com.xyz.threadsimple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor1 implements Runnable {
    private  int id;

    @Override
    public void run() {
        System.out.println("Starting : " + id);
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        System.out.println("Completed! " + id);
    }

    public Processor1 (int id){
        this.id = id;
    }
}

public class ThreadPools {
    public static void  main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i=0; i<5; i++){
            executor.submit(new Processor1(i));
        }

        executor.shutdown();
        System.out.println("All Tasks Submmitted!");
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {}

        System.out.println("Exiting......");

    }
}
