package com.laibao.spring.reactive;

import com.laibao.spring.reactive.functionalinterface.FunctionInterfaceOne;

public class LambdaDemoOne {

    public static void main(String[] args) {

        FunctionInterfaceOne functionInterfaceOne = (int i) -> i * 100;
        double value1 = functionInterfaceOne.doubleNumberValue(100);
        System.out.println(value1);
        functionInterfaceOne.addSum(100,200);
        FunctionInterfaceOne.getName("金戈");
    }
}
