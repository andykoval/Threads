package com.company;

public class ThreadTest1 {
    private int cnt;

    public ThreadTest1() {
        cnt = 0;
    }

    public static void main(String[] args) {


        Thread myThr1 = new Thread(new MyThread("Child1"));
        Thread myThr2 = new Thread(new MyThread("Child2"));
        // write your code here
        System.out.println("Running main Thread");
        for (int i = 0; i < 50; i++) {
            System.out.print(". ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.print("Thread is interrupted with: ");
                e.printStackTrace();
            }
        }
    }
}
