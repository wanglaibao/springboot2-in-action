package com.laibao.spring.reactive.lambda.streamexample;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {

    public static void main(String[] args) {
        String str = "my name is 007 and you my name is 007 and you";
        str.chars().parallel().forEach(i -> System.out.println((char) i));
        System.out.println();
        str.chars().parallel().forEachOrdered(i -> System.out.println((char) i));
        System.out.println();

        Stream.of(str.split(" ")).collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
        Stream.of(str.split(" ")).collect(Collectors.toSet()).forEach(System.out::print);


        Optional<String> stringOptional = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "||"+s2);
        stringOptional.ifPresent(s -> System.out.println(s));


        String aa  = Stream.of(str.split(" ")).reduce("",(s1, s2) -> s1 + "||"+s2);
        System.out.println(aa);


        Optional<String> maxValue = Stream.of(str.split(" ")).max((s1,s2) -> s1.compareTo(s2));
        System.out.println("maxValue : "+maxValue.orElse("none"));


        OptionalInt optionalInt = new Random().ints().findFirst();
        System.out.println(optionalInt.orElse(0));
    }
}
