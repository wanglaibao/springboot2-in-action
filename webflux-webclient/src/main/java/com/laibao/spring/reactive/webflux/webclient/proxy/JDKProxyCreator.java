package com.laibao.spring.reactive.webflux.webclient.proxy;

import com.laibao.spring.reactive.webflux.webclient.annotation.ApiServer;
import com.laibao.spring.reactive.webflux.webclient.beans.MethodInfo;
import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import com.laibao.spring.reactive.webflux.webclient.interfaces.ProxyCreator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理来实现代理类
 */
public class JDKProxyCreator implements ProxyCreator {

    @Override
    public Object createProxy(Class<?> clazz) {

        //1: 根据接口得到API服务器信息
        ServerInfo serverInfo = extractServerInfo(clazz);

        //2: 创建动态代理对象
        Object proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                                                    new Class[]{clazz},
                                                    new InvocationHandler() {
                                                        @Override
                                                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                                           //3: 根据方法和参数得到调用方法的信息
                                                            MethodInfo methodInfo = extractMethodInfo(method,args);

                                                            //4:结合服务器信息和方法信息来调用REST接口
                                                            return null;
                                                        }
                                                    });

        return proxyObj;
    }

    /**
     * 提取方法信息
     * @param method
     * @param args
     * @return MethodInfo
     */
    private MethodInfo extractMethodInfo(Method method,Object[] args) {
        MethodInfo methodInfo = new MethodInfo();
        return methodInfo;
    }


    /**
     * 提取服务器信息
     * @param clazz
     * @return ServerInfo
     */
    private ServerInfo extractServerInfo(Class<?> clazz) {
        ServerInfo serverInfo = new ServerInfo();
        ApiServer apiServer = clazz.getAnnotation(ApiServer.class);
        serverInfo.setUrl(apiServer.value());
        return serverInfo;
    }
}
