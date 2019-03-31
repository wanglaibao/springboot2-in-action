package com.laibao.spring.reactive.routerfunction.handler;

import com.laibao.spring.reactive.routerfunction.exception.CheckException;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class ExceptionHandler implements WebExceptionHandler{

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        //设置响应头400
        serverHttpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        //设置返回类型
        serverHttpResponse.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        //异常信息
        String errorMessage = convertToString(ex);

        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(errorMessage.getBytes());
        return serverHttpResponse.writeWith(Mono.just(dataBuffer));
    }

    private String convertToString(Throwable ex) {
            if (ex instanceof CheckException) {
                //已知异常
                CheckException checkException = (CheckException) ex;
                return checkException.getFieldName()+" :invalid value "+checkException.getFieldValue();
            }else {
                //未知异常
                ex.printStackTrace();
                return ex.toString();
            }
    }
}
