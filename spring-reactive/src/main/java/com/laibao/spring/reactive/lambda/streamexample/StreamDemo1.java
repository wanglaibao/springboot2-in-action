package com.laibao.spring.reactive.lambda.streamexample;

import java.util.stream.IntStream;

public class StreamDemo1 {

    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;
        for(int i=0;i<arrays.length;i++) {
            sum += arrays[i];
        }
        System.out.println("the sum is : "+sum);


        IntStream intStream = IntStream.of(1,2,3,4,5,6,7,8,9,10);
        int sum1 = intStream.sum();
        System.out.println("the sum1 is "+sum1);
    }
}
