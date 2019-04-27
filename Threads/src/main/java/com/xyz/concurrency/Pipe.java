package com.xyz.concurrency;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

class PipeReaderThread implements  Runnable{
    String name;
    PipedReader pipedReader;

    PipeReaderThread(String name, PipedReader pipedReader) {
        this.name = name;
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        while(true) {
            try {
                char c = (char) pipedReader.read();
                System.out.println(name + " : " + c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class PipeWriterThread implements Runnable {
    String name;
    PipedWriter pw;

    PipeWriterThread(String name, PipedWriter pw) {
        this.name = name;
        this.pw = pw;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        int i = 165;
        while (true) {
            try {
                pw.write(i++);
                pw.flush();
                t.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}


public class Pipe {

    public static void main(String args[]) {

        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter();

        try {
            pw.connect(pr);
            Thread t1 = new Thread(new PipeReaderThread("Reader", pr));
            Thread t2 = new Thread(new PipeWriterThread("Writer",pw));
            t1.start();
            t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
