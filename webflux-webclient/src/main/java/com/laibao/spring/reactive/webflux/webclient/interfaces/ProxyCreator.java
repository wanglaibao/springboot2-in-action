package com.laibao.spring.reactive.webflux.webclient.interfaces;

/**
 * 创建代理类的接口
 */
public interface ProxyCreator {
    /**
     * 根据接口类型来创建代理类实例对象
     * @param clazz
     * @return
     */
    Object createProxy(Class<?> clazz);
    //T createProxy(Class<?> clazz);
}
