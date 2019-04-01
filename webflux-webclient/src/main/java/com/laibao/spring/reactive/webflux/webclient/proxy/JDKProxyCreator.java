package com.laibao.spring.reactive.webflux.webclient.proxy;

import com.laibao.spring.reactive.webflux.webclient.annotation.ApiServer;
import com.laibao.spring.reactive.webflux.webclient.beans.MethodInfo;
import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import com.laibao.spring.reactive.webflux.webclient.interfaces.ProxyCreator;
import com.laibao.spring.reactive.webflux.webclient.interfaces.RestHandler;
import com.laibao.spring.reactive.webflux.webclient.resthandler.WebClientRestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;

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
        RestHandler restHandler = new WebClientRestHandler();

        //初始化服务器信息(初始化WebClient信息)
        restHandler.init(serverInfo);


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
     * 根据方法定义和调用参数得到调用的相关信息
     * @param method
     * @param args
     * @return MethodInfo
     */
    private MethodInfo extractMethodInfo(Method method,Object[] args) {
        MethodInfo methodInfo = new MethodInfo();

        this.extractUrlAndMethod(method, methodInfo);

        this.extractRequestParamAndBody(method, args, methodInfo);

        return methodInfo;
    }

    /**
     *  得到方法参数和请求体body
     * @param method
     * @param args
     * @param methodInfo
     */
    private void extractRequestParamAndBody(Method method, Object[] args, MethodInfo methodInfo) {
        Parameter[] parameters = method.getParameters();
        Map<String,Object> params = new LinkedHashMap<>();
        methodInfo.setParams(params);
        for (int i = 0;i < parameters.length;i++) {
            //是否带 @PathVariable 注解
            PathVariable pathVariable =  parameters[i].getAnnotation(PathVariable.class);
            if (pathVariable != null) {
                params.put(pathVariable.value(),args[i]);
            }

            //是否带 @RequestBody 注解
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                methodInfo.setBody((Mono<?>) args[i]);
            }
        }
    }

    /**
     * 得到请求的URL和请求方法
     * @param method
     * @param methodInfo
     */
    private void extractUrlAndMethod(Method method, MethodInfo methodInfo) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation:annotations) {
            //GET
            if (annotation instanceof GetMapping) {
                GetMapping getMapping = (GetMapping) annotation;
                methodInfo.setUrl(getMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.GET);
            }
            // POST
            else if (annotation instanceof PostMapping) {
                PostMapping postMapping = (PostMapping) annotation;
                methodInfo.setUrl(postMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.POST);
            }
            //PUT
            else if(annotation instanceof PutMapping) {
                PutMapping putMapping = (PutMapping) annotation;
                methodInfo.setUrl(putMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.PUT);
            }
            //DELETE
            else if (annotation instanceof DeleteMapping) {
                DeleteMapping deleteMapping = (DeleteMapping) annotation;
                methodInfo.setUrl(deleteMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.DELETE);
            }
        }
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
