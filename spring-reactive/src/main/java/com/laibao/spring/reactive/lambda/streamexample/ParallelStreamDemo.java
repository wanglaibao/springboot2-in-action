package com.laibao.spring.reactive.lambda.streamexample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
public class ParallelStreamDemo {
    public static void main(String[] args)  {
        //IntStream.rangeClosed(1,20).peek(ParallelStreamDemo::printOne).count();
        //IntStream.rangeClosed(1,20).parallel().peek(ParallelStreamDemo::printTwo).count();

//        IntStream.rangeClosed(1,20)
//                //先并行
//                .parallel().peek(ParallelStreamDemo::printTwo)
//                //后串行
//                .sequential().peek(ParallelStreamDemo::printOne)
//                .count();


        IntStream.rangeClosed(1,20)
                //先串行
                .sequential()
                .peek(ParallelStreamDemo::printOne)
                //后并行
                .parallel().peek(ParallelStreamDemo::printTwo)
                .count();

        //System.err.println("Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors());
        //并行流默认使用的线程池是  ForkJoinPool.commonPool
        // 默认的核数： Runtime.getRuntime().availableProcessors());

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","10");
        IntStream.rangeClosed(1,20)
                //并行
                .parallel().peek(ParallelStreamDemo::printTwo)
                .count();

        //使用自定义线程池不使用默认的线程池，防止任务被阻塞
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        forkJoinPool.submit(() ->  IntStream.rangeClosed(1,200)
                                            .parallel().peek(ParallelStreamDemo::printTwo)
                                            .count()
                            );

        forkJoinPool.shutdown();

        synchronized (forkJoinPool) {
            try {
                forkJoinPool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("主线程结束了");
    }

    private static void printOne(int intValue) {
        System.out.println("串行流测试 "+intValue);
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printTwo(int intValue) {
        System.err.println("并行流测试 "+intValue);
        System.err.println("该线程的名称为: "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
