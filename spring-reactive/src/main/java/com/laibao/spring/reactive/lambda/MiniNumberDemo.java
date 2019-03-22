package com.laibao.spring.reactive.lambda;

import java.util.stream.IntStream;

public class MiniNumberDemo {

    public static void main(String[] args) {

        int[] numbers = {33,55,-55,100,-666};

        int miniValue = Integer.MAX_VALUE;
        for (int number:numbers) {
                if (number < miniValue) {
                    miniValue = number;
                }
        }
        System.out.println("miniValue is "+miniValue);

        // java8
        IntStream intStream = IntStream.of(numbers);
        int smallValue = intStream.min().getAsInt();
        System.out.println("smallValue is "+smallValue);

        int smallValue2 = IntStream.of(numbers).parallel().min().getAsInt();
        System.out.println("smallValue2 is "+smallValue2);
    }
}
