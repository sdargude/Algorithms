package com.xyz.threadsimple;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private BlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);
    public static void main (String[] args ) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                }catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                }catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Done!");
    }

    private void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
            System.out.println("Producer Size of queue is :" + queue.size());
        }
    }

    private void consumer() throws InterruptedException{
        Random random = new Random();

        while(true) {
            Thread.sleep(100);

            if (random.nextInt(10) == 0) {
                Integer value = queue.take();
                System.out.println("Value is taken " + value + " Sizeof queue is " + queue.size());
            }
        }
    }



 }
