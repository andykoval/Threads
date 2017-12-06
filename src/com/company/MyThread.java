package com.company;

/**
 * Created by andy on 04.12.2017.
 */
public class MyThread implements Runnable {
    private Thread thread;

    public MyThread(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " is starting");
        try {
            for (int i = 0; i < 10; i++)
                System.out.println(thread.getName() + " is running and printing " + i);
            thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.print("Thread is interrupted with: ");
            e.printStackTrace();
        }
        System.out.println(thread.getName() +" is end");
    }
}

