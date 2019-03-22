package com.laibao.spring.reactive.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionInterDemoOne {

    public static void main(String[] args) {
        Predicate<Integer> predicate = (Integer a) ->  a > 100;
        IntPredicate intPredicate = (int b) -> b < 10;
        Consumer<String> consumer = (String str) -> System.out.println(str);
        IntConsumer intConsumer = i -> System.out.println(i);
        //
        System.out.println(predicate.test(1000));
        consumer.accept("我是金戈");
        intConsumer.accept(1000);
        System.out.println(intPredicate.test(34));
    }
}
