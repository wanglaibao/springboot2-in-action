package com.laibao.spring.reactive.webflux.webclient.interfaces;

import com.laibao.spring.reactive.webflux.webclient.beans.MethodInfo;
import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * REST请求调用handler
 */
public interface RestHandler {
    //Object invokeRest(ServerInfo serverInfo, MethodInfo methodInfo);
    /**
     * 调用REST请求返回结果
     * @param methodInfo
     * @return Object
     */
    Object invokeRest(MethodInfo methodInfo);

    /**
     *
     * 初始化服务器信息
     * @param serverInfo
     */
    default void init(ServerInfo serverInfo) {
        WebClient.create(serverInfo.getUrl());
    }
}
