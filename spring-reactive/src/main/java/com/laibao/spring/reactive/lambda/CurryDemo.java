package com.laibao.spring.reactive.lambda;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化的定义:把多个参数的函数转换为只有一个参数的函数
 * 柯里化的目标:函数标准化
 */
public class CurryDemo {

    public static void main(String[] args) {
        // 级联表达式 x -> y -> x + y;
        Function<Integer,Function<Integer,Integer>> function = x -> y -> x + y;
        int value = function.apply(100).apply(200);
        System.out.println(value);


        //x -> y -> z -> x + y + z;
        Function<Integer,Function<Integer,Function<Integer,Integer>>> functionFunction = x -> y -> z -> x + y + z;
        //function.apply(100);
        System.out.println(functionFunction.apply(100).apply(200).apply(300));


        int[] numbers = {1,2,3,4,5,6,7,8,9};
        Function function1 = functionFunction;
        for (int number:numbers) {
                if (function1 instanceof Function) {
                    Object object = function1.apply(number);
                    if (object instanceof Function) {
                        function1 = (Function) object;
                    }else {
                        System.out.println(object);
                    }
                }
        }
    }
}
