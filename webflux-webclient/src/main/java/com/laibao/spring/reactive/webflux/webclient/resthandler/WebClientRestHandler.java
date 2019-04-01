package com.laibao.spring.reactive.webflux.webclient.resthandler;

import com.laibao.spring.reactive.webflux.webclient.beans.MethodInfo;
import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import com.laibao.spring.reactive.webflux.webclient.interfaces.RestHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientRestHandler implements RestHandler{

    private WebClient webClient;

    @Override
    public Object invokeRest(MethodInfo methodInfo) {
        return null;
    }

    @Override
    public void init(ServerInfo serverInfo) {
        this.webClient = WebClient.create(serverInfo.getUrl());
    }
}
