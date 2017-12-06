package com.company;

import java.util.concurrent.*;

/**
 * Created by andy on 06.12.2017.
 */
public class FutureTask2 {

    public static void main(String[] args) throws InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                int count = 0;
                while (!Thread.currentThread().isInterrupted() && count < 3) {
                    System.out.println("Is started");
                    count++;
                    Thread.sleep(1000);
                }
                return "I finished!";
            }
        });

        new Thread(futureTask).start();

        Thread.sleep(2000);

        futureTask.cancel(true);

        System.out.println(futureTask.isCancelled());

        System.out.println(futureTask.isDone());

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello!" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("pool is shutdown? - " + pool.isShutdown());
        pool.shutdown();
        System.out.println("pool is shutdown? - " + pool.isShutdown());

        System.out.println("");

        ExecutorService pool2 = new ThreadPoolExecutor(1,10, 1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
        for (int i = 0; i < 5; i++) {
            pool2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello!" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool2.shutdown();
        System.out.println("pool is shutdown? - " + pool.isShutdown());
    }
}
