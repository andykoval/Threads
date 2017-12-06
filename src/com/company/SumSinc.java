package com.company;

/**
 * Created by andy on 04.12.2017.
 */
public class SumSinc {

    private int summArr;

    public synchronized int summ(int a[]) {
        summArr = 0;

        for (int i = 0; i < a.length; i++) {
            summArr += a[i];
            System.out.println("Now summArr " + Thread.currentThread() + "is: " + summArr);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.print("Thread is interrupted with: ");
                e.printStackTrace();
            }
        }
        return summArr;
    }
}
