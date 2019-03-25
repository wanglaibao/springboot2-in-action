package com.laibao.spring.reactive.lambda.streamexample;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {

    public static void main(String[] args) {
        String str = "my name is 007 and you my name is 007 and you";
        str.chars().parallel().forEach(i -> System.out.println((char) i));
        System.out.println();
        str.chars().parallel().forEachOrdered(i -> System.out.println((char) i));
        System.out.println();

        Stream.of(str.split(" ")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        Stream.of(str.split(" ")).collect(Collectors.toSet()).forEach(System.out::println);
    }
}
