package com.xyz.concurrency;

interface Callback{
    void dosometask();
}

class AsyncTask implements Callback{
    public void dosometask (){
        System.out.println("Task is getting executed.....");
        try {
            Thread.sleep(500);
        }catch(InterruptedException e) {}

        System.out.println("Task Done!");
    }
}

public class AsyncCallBack {

    Callback callback;

    AsyncCallBack(Callback callback) {
        this.callback = callback;
    }

    void submit (){

    }

}
