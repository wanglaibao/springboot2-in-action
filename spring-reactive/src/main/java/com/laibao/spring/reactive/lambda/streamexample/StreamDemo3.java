package com.laibao.spring.reactive.lambda.streamexample;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo3 {

    public static void main(String[] args) {
        String str = "my name is 007 and you";

        //把每个单词的长度打印出来
        Stream.of(str.split(" ")).filter(s -> s.length() > 0).map(s -> s.length()).forEach(System.out::println);

        Stream<String> stringStream = Stream.of(str.split(" "));
        // stringStream.forEach(System.out::println); it is error here
        IntStream intStream = stringStream.mapToInt(strValue -> strValue.length());
        System.out.println();
        intStream.forEach(System.out::println);
        System.out.println();

        Stream.of(str.split("")).filter(s -> s.length() > 0).flatMap(s -> s.chars().boxed()).forEach(System.out::println);

        // flatMap A -> B 【B是A的集合属性,或者调用A的某个方法可以返回集合对象】,这个函数flatMap最终返回的是 B 的流 【B 的 Stream】
        Stream.of(str.split("")).filter(s -> s.length() > 0).flatMap(s -> s.chars().boxed()).forEach(i -> System.out.println((char) i.intValue()));


        // peek是一个中间操作，适合Debug调试，不适合生产环境有副作用
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);
    }
}
