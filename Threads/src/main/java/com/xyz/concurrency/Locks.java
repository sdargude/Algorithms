package com.xyz.concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintTask implements Callable<Long> {

    PrintQueue  printQueue;
    String taskName;
    Thread t ;

    PrintTask(PrintQueue printQueue, String taskName) {
        this.printQueue = printQueue;
        this.taskName = taskName;
    }

    @Override
    public Long call() {
        t = Thread.currentThread();
       // System.out.print ("Going to print document " + taskName + " ");
        return  printQueue.printJob(taskName,t);
    }
}


class PrintQueue {

    Random random = new Random();
    private Lock lock = new ReentrantLock();

    synchronized Long printJob(String taskName, Thread t) {

        long sleeptime = random.nextInt(3000);

        lock.lock();
        try {
            System.out.print ("Printing " + taskName + "  :");
            Thread.sleep(sleeptime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(taskName + " completed in " + sleeptime);
            lock.unlock();
        }
        return sleeptime;
    }
}


class test {
    int counter = 0;

    int incrementcounter() {
        return ++counter;
    }
}


public class Locks {
    public static void main(String args[]) {
        PrintQueue pq = new PrintQueue();
        List<Future<Long>> results = new ArrayList<>();
        ThreadPoolExecutor te = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        for (int i=0 ; i<10; i++) {
           results.add(te.submit(new PrintTask(pq,"  job"+i)));
        }

        for (int i=0; i<10; i++) {
            try {
                System.out.println("Result " + results.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        te.shutdown();

        test t1 = new test();
        test t2 = new test();
        System.out.println(t1.incrementcounter());
        System.out.println(t1.incrementcounter());
        System.out.println(t2.incrementcounter());

    }
}
