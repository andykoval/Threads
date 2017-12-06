package com.company;

/**
 * Created by andy on 04.12.2017.
 */
public class MyThread2 implements Runnable {
    private Thread thread;
    private int sumArr;
    private int a[];
    private static SumSinc sumSinc = new SumSinc();


    MyThread2(String name, int[] a) {
        thread = new Thread(this, name);
        this.a = a;
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " is starting");
        sumArr = sumSinc.summ(a);
        System.out.println(thread.getName() + " is end with answer " + sumArr);
    }
}
