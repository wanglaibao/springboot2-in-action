package com.laibao.spring.reactive.defaultmethod;

public interface DefaultMethodInterfaceThree extends DefaultMethodInterface,DefaultMethodInterfaceTwo{
    @Override
    default String sayHello() {
        return DefaultMethodInterface.super.sayHello();
    }
}
