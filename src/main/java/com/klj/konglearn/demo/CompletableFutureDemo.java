package com.klj.konglearn.demo;

import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CompletableFutureDemo {

    private static StopWatch sw = new StopWatch();

    public static void main(String[] args) {
        allOfTest();
    }

    private static void allOfTest(){
        Function<Integer, Runnable> delayFunction = (delayTime) -> () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(delayTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable d1 = delayFunction.apply(1000);
        Runnable d2 = delayFunction.apply(2000);
        Runnable d3 = delayFunction.apply(3000);

        try {
            sw.start();
            CompletableFuture.allOf(
                    CompletableFuture.runAsync(d1),
                    CompletableFuture.runAsync(d2),
                    CompletableFuture.runAsync(d3)).get();
            sw.stop();
            System.out.println(sw.prettyPrint());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
