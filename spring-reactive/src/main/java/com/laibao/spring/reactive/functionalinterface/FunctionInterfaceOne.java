package com.laibao.spring.reactive.functionalinterface;

@FunctionalInterface
public interface FunctionInterfaceOne {
    int doubleNumberValue(int number);

    default int addSum(int x,int y) {
        return x + y;
    }

    static String getName(String name) {
        return "我的名字是:"+name;
    }
}
