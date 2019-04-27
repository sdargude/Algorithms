package com.xyz.concurrency;


import java.util.ArrayList;
import java.util.List;

class PoolWorker extends Thread {

    private List<Runnable> tasklist;

    PoolWorker(List<Runnable> tasklist) {
        this.tasklist = tasklist;
    }

    public void run () {
        while(true) {
            synchronized (tasklist) {
                while (tasklist.isEmpty()) {
                    try {
                        tasklist.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                tasklist.remove(0).run();
                tasklist.notifyAll();
            }
        }
    }

}


class ThreadPool {
    private List<Runnable> list;
    private int threadcount;
    private Thread workerlist[];

    ThreadPool(int threadcount) {
        this.list = new ArrayList<>();
        this.threadcount = threadcount;
        this.workerlist = new PoolWorker[threadcount];

        for (int i=0; i<threadcount; i++) {
            workerlist[i] = new PoolWorker(list);
            workerlist[i].start();
        }
    }


    void submmit(Runnable tasks){
            synchronized (list) {
                list.add(tasks);
                System.out.println(list.size());
                list.notifyAll();
            }
    }

    void shutdown() {
        for (int i = 0; i<threadcount; i++) {
            workerlist[i]=null;
        }
    }

}


class MyTask implements  Runnable {

    @Override
    public void run(){
        System.out.println("This is thread " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CustomThreadPoolExample {
    public static void main(String args[]) {
        ThreadPool tp = new ThreadPool(5);

        for (int i = 0; i< 10; i++) {
            tp.submmit(new MyTask());
        }

        tp.shutdown();
    }
}
