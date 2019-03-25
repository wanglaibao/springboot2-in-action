package com.laibao.spring.reactive.lambda.streamexample;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> integerStream =list.stream();

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        IntStream intStream = Arrays.stream(intArray);

        DoubleStream doubleStream = DoubleStream.of(12.01,23.01,23.04);
        IntStream intStream1 = IntStream.rangeClosed(1,100);
        IntStream intStream0 = IntStream.range(1,100);
        IntStream intStream2 = new Random().ints().limit(100);


        Random random = new Random();
        IntStream intStream3 = IntStream.generate(() -> random.nextInt()).limit(100);
    }
}
