package com.laibao.spring.reactive.lambda.streamexample;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,20).peek(ParallelStreamDemo::printOne).count();
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
        System.out.println("并行流测试 "+intValue);
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
