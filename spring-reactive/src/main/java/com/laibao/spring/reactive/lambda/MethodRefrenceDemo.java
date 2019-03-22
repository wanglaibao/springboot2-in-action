package com.laibao.spring.reactive.lambda;

import com.laibao.spring.reactive.lambda.model.Dog;

import java.util.function.*;

public class MethodRefrenceDemo {

    public static void main(String[] args) {
        Dog dog0 = new Dog();
        dog0.eat(20);
        // Consumer<String> stringConsumer = str -> System.out.println(str)
        // 方法应用
        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("金戈");

        /**
         * 静态方法的引用
         */
        Consumer<Dog> dogConsumer = Dog::bark;
        Dog dog = new Dog();
        dogConsumer.accept(dog);

        /**
         * 非静态方法，使用对象的实例方法来引用
         */
        Dog dog1 = new Dog();
        Function<Integer,Integer> function1 = dog1::eat;
        UnaryOperator<Integer> unaryOperator = dog1::eat;
        IntUnaryOperator intUnaryOperator = dog1::eat;
        System.out.println("还剩下 "+ function1.apply(20)+"斤");
        System.out.println();
        System.out.println("还剩下 "+ unaryOperator.apply(20)+"斤");
        System.out.println();
        System.out.println("还剩下 "+ intUnaryOperator.applyAsInt(20)+"斤");

        /**
         * 非静态方法，使用类名来引用实例方法
         */
        //Dog::eat;
        BiFunction<Dog,Integer,Integer> biFunction = Dog::eat;
        System.out.println("还剩下 "+ biFunction.apply(dog1,20)+"斤");



        /**
         * 构造函数的方法引用【无参构造函数】
         */
        //Dog::new;
        Supplier<Dog> dogSupplier = Dog::new;
        System.out.println("创建了新的对象: "+dogSupplier.get());


        /**
         * 构造函数的方法引用【有参数构造函数】
         */
        Function<String,Dog> stringDogFunction = Dog::new;
        System.out.println("创建了新的对象: "+stringDogFunction.apply("旺财"));
    }
}
