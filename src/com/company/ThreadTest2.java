package com.company;

/**
 * Created by andy on 04.12.2017.
 */
public class ThreadTest2 {


    public static void main(String[] args) {
        int a [] = {1,2,3,4,5,6,7,8,9};
        Thread myThr1 = new Thread(new MyThread2("Child#1", a));
        Thread myThr2 = new Thread(new MyThread2("Child#2", a));
    }
}
