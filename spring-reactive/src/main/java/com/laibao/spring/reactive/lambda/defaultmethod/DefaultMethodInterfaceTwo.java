package com.laibao.spring.reactive.lambda.defaultmethod;

public interface DefaultMethodInterfaceTwo {
    default String sayHello() {
        return "你好啊，欢迎来这里: "+ DefaultMethodInterfaceTwo.class.getName();
    }

    static String welcome(String message) {
        return "你是哪里人啊，怎么来这里了啊, " + message;
    }
}
