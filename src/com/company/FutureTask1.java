package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by andy on 06.12.ew2017.
 */
public class FutureTask1  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello string!";
            }
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
