package com.laibao.spring.reactive.webflux.webclient.resthandler;

import com.laibao.spring.reactive.webflux.webclient.beans.MethodInfo;
import com.laibao.spring.reactive.webflux.webclient.beans.ServerInfo;
import com.laibao.spring.reactive.webflux.webclient.interfaces.RestHandler;
import org.springframework.stereotype.Component;

@Component
public class WebClientRestHandler implements RestHandler{

    @Override
    public Object invokeRest(MethodInfo methodInfo) {
        return null;
    }

    @Override
    public void init(ServerInfo serverInfo) {

    }
}
