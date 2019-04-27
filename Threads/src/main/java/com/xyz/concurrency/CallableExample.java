package com.xyz.concurrency;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.*;

class Worker implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random  r = new Random();
        int val = r.nextInt(100);
        Thread t = Thread.currentThread();
        t.sleep(val*100);
        return val;
    }
}

public class CallableExample  {

    static int poolSize = 5;

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        List<Future<Integer>> resultlist = new ArrayList<>();
        ThreadPoolExecutor pool =  (ThreadPoolExecutor) Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i< poolSize; i++) {
            resultlist.add( pool.submit(new Worker()));
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("/tmp/a.txt"));
        }catch (Exception e) {}


        for (int i = 0; i< poolSize;i++){
            System.out.println("This is Future : " + resultlist.get(i).get());
        }

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        treeMap.

        pool.shutdown();
    }
}
