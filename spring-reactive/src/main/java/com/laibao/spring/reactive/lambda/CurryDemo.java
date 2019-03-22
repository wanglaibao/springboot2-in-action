package com.laibao.spring.reactive.lambda;

import java.util.function.Function;

/**
 * 级联表达式和科里化
 */
public class CurryDemo {

    public static void main(String[] args) {
        // 级联表达式 x -> y -> x + y;
        Function<Integer,Function<Integer,Integer>> function = x -> y -> x + y;
        int value = function.apply(100).apply(200);
        System.out.println(value);
    }
}
