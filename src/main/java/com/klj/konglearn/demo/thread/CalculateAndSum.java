package com.klj.konglearn.demo.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiFunction;

import static java.lang.System.out;

/**
 * 假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小，
 * 所有线程都统计完毕交给Thread5线程去做汇总
 *
 * Thread 和 Runnable 无返回结果，这里不做考虑
 *
 */
public class CalculateAndSum {

    //Callable:有返回值的线程
    //Future:获得线程的返回值
    private static Integer solution1() throws Exception {
        BiFunction<String, Integer, Callable<Integer>> calFunc = (n, s) ->
                () -> {
                    String name = Thread.currentThread().getName();
                    out.println(String.format("thread %s calculate %s size %d", name,n, s));
            return s;
        };
        Callable<Integer> c = calFunc.apply("C", 3);
        Callable<Integer> d = calFunc.apply("D", 5);
        Callable<Integer> e = calFunc.apply("E", 8);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = executorService.invokeAll(Arrays.asList(c, d, e));

        int total = futures.stream().mapToInt(f -> {
            try {
                return f.get();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
            return 0;
        }).sum();
        out.println(String.format("toal size %d", total));
        executorService.shutdown();
        return total;
    }

    /**
     * CountDownLatch
     * 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行
     * CountDownLatch 是计数器, 线程完成一个就记一个, 就像 报数一样, 只不过是递减的.
     * @return
     */
    private static Integer solutionCountDownLatch(){
        return 0;
    }

    public static void main(String[] args) throws Exception {
        solution1();
    }

}
