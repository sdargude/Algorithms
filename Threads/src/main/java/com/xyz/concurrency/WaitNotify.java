package com.xyz.concurrency;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


class Producer implements  Runnable{
    private final List<Integer> taskQueue;
    private final int size;

    Producer(List<Integer> taskQueue, int size) {
        this.size = size;
        this.taskQueue = taskQueue;
    }

    public void run(){
        Random r = new Random();

        while(true) {
            int i = r.nextInt(100);
            try{
                produce(i);
                int random = ThreadLocalRandom.current().nextInt(1,100);
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public void produce(int count) throws InterruptedException {

        synchronized (taskQueue) {
            while(taskQueue.size() == size) {
                System.out.println("Ahh! Deserved break!");
                taskQueue.wait();
            }

            if (taskQueue.size() < size) {
                taskQueue.add(count);
                System.out.println("Produced item " + count);
                taskQueue.notifyAll();
            }
        }

    }

}

class Consumer implements Runnable {
    private final List<Integer> taskQueue;

    Consumer(List taskQueue) {
        this.taskQueue = taskQueue;
    }


    void consume() throws InterruptedException{
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                    taskQueue.wait();
            }

            if (!taskQueue.isEmpty()) {
                int value = taskQueue.remove(0);
                System.out.println("Consumed " + value);
                taskQueue.notifyAll();
            }

        }
    }


    public void run(){

        while(true) {
            try {
                consume();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class WaitNotify {

    public static void main(String args[]) {
        List<Integer> taskList = new ArrayList<>();
        Producer p = new Producer(taskList, 5);
        Consumer c = new Consumer(taskList);
        Consumer c1 = new Consumer(taskList);

        Thread tp = new Thread(p);
        Thread tc = new Thread(c);
        Thread tc1 = new Thread(c1);

        tp.start();
        tc.start();

        try {
            tp.join();
            tc.join();
            tc1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
