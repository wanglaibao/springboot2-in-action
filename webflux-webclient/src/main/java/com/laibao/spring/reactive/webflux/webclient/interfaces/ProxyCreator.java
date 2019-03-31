package com.laibao.spring.reactive.webflux.webclient.interfaces;

/**
 * 创建代理类的接口
 */
public interface ProxyCreator {
    Object createProxy(Class<?> clazz);

    //T createProxy(Class<?> clazz);
}
