package com.xyz.threadsimple;

import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean running = true;
    public void run() {
        int i = 0;
        while (running) {
            System.out.println("Hello " + i);
            i++;
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        System.out.println("Stooping...........");
        running = false;
    }
}

public class VolatileExample {
    public static void main(String [] args) {
        Processor proc1 = new Processor();
        proc1.start();
        System.out.print("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}
