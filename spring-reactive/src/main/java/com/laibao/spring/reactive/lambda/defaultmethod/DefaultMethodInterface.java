package com.laibao.spring.reactive.lambda.defaultmethod;

public interface DefaultMethodInterface {

    default String sayHello() {
        return "你好啊，欢迎来这里: "+DefaultMethodInterface.class.getName();
    }

    static String welcome(String message) {
        return "你是哪里人啊，怎么来这里了啊, " + message;
    }
}
