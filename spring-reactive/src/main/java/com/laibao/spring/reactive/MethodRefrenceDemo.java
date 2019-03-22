package com.laibao.spring.reactive;

import java.util.function.Consumer;

public class MethodRefrenceDemo {

    public static void main(String[] args) {
        // Consumer<String> stringConsumer = str -> System.out.println(str)
        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("金戈");
    }
}
