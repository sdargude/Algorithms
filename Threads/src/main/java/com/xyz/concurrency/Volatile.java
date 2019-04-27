package com.xyz.concurrency;


import java.util.Scanner;

public class Volatile extends  Thread {

    private volatile boolean running = true;

    public void run(){
        int i = 0;

        while(running) {
            System.out.println("Running " + i++ );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        System.out.println("Setting Running to false;");
        running = false;
    }

    public static void main(String args[]) {
        Volatile v = new Volatile();

        v.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        v.shutdown();
        System.out.println("Stopped.");
    }

}
