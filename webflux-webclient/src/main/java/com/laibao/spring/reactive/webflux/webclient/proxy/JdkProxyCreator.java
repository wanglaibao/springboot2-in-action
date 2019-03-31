package com.laibao.spring.reactive.webflux.webclient.proxy;

import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import com.laibao.spring.reactive.webflux.webclient.interfaces.ProxyCreator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyCreator implements ProxyCreator {

    @Override
    public Object createProxy(Class<?> clazz) {
        //根据接口得到API服务器信息
        ServerInfo serverInfo = extratServerInfo(clazz);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }

    private ServerInfo extratServerInfo(Class<?> clazz) {
        return null;
    }
}
