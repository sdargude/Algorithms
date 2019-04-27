package com.xyz.sorting;

import java.util.PriorityQueue;

public class RunningMedian {

    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;


    RunningMedian() {
        minheap = new PriorityQueue<>(100, (o1,o2) -> o1-o2);
        maxheap = new PriorityQueue<>(100, (o1,o2) -> o2-o1);
    }

    private void rebalance() {
        if (Math.abs(minheap.size() - maxheap.size()) <= 1) return;

        if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }else {
            minheap.add(maxheap.poll());
        }
    }

    double consumeInteger(int num) {

        if (minheap.size() == 0 || minheap.peek() < num) {
            minheap.add(num);
        }else {
            maxheap.add(num);
        }

        rebalance();

        if (minheap.size() == maxheap.size())
            return (double) (minheap.peek() +maxheap.peek()) /2;
        else if (minheap.size() > maxheap.size()) return (double) minheap.peek();
        else return (double)maxheap.peek();
    }

    public static void main(String [] args ){
        RunningMedian r1 = new RunningMedian();
        System.out.println(r1.consumeInteger(1));
        System.out.println(r1.consumeInteger(2));
        System.out.println(r1.consumeInteger(3));
        System.out.println(r1.consumeInteger(12));
        System.out.println(r1.consumeInteger(21));
        System.out.println(r1.consumeInteger(24));


    }
}
