package com.laibao.spring.reactive.lambda;

import com.laibao.spring.reactive.lambda.functionalinterface.IMath;
import com.laibao.spring.reactive.lambda.functionalinterface.IMathTwo;

public class TypeInferenceDemo {

    public static void main(String[] args) {

        //变量类型定义
        IMath iMath1 = (x,y) -> x + y;

        //定义数组
        IMath[] iMaths = {(x,y) -> x + y};


        //强制类型转换
        Object objMath = (IMath) (x, y) -> x + y;

        createLambdaExpress();

        System.out.println(test((IMath)(x, y) -> x + y));
        System.out.println(test((IMathTwo)(x, y) -> x + y));
    }

    private static IMath createLambdaExpress() {
        return (x,y) -> x + y;
    }

    private static int test(IMath iMath) {
        return iMath.add(10,20);
    }

    private static int test(IMathTwo iMath) {
        return iMath.add(10,20);
    }
}
