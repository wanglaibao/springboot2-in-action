package com.laibao.spring.reactive.webflux.webclient.proxy;

import com.laibao.spring.reactive.webflux.webclient.annotation.ApiServer;
import com.laibao.spring.reactive.webflux.webclient.beans.MethodInfo;
import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import com.laibao.spring.reactive.webflux.webclient.interfaces.ProxyCreator;
import com.laibao.spring.reactive.webflux.webclient.interfaces.RestHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理来实现代理类
 */
@Slf4j
public class JDKProxyCreator implements ProxyCreator {

    @Override
    public Object createProxy(Class<?> clazz) {
        log.info("createProxy : "+clazz);
        //1: 根据接口得到API服务器信息
        ServerInfo serverInfo = extractServerInfo(clazz);

        log.info("serverInfo :  "+serverInfo);
        //给每一个代理类实现一个REST请求处理器
        RestHandler restHandler = null;

        //初始化服务器信息(初始化WebClient信息)


        //2: 创建动态代理对象
        Object proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                                                    new Class[]{clazz},
                                                    new InvocationHandler() {
                                                        @Override
                                                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                                           //3: 根据方法和参数得到调用方法的信息
                                                            MethodInfo methodInfo = extractMethodInfo(method,args);
                                                            log.info("methodInfo :  "+methodInfo);
                                                            //4:结合服务器信息和方法信息来调用REST接口
                                                            return restHandler.invokeRest(methodInfo);
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
