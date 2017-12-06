package com.company;

/**
 * Created by andy on 06.12.2017.
 */
public class LectThread {
    public static volatile boolean runT = true;

    private static class SomeThread extends Thread{
        @Override
        public void run() {
            int count = 0;
            while (runT){
                try {
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName()+" is running "+ ++count);
                } catch (InterruptedException e) {
                    runT=false;
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i<100; i++){
            new SomeThread().start();
        }
        Thread.sleep(1000);
        runT=false;

    }
}
