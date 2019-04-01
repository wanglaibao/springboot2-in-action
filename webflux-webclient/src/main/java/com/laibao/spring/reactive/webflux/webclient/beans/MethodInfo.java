package com.laibao.spring.reactive.webflux.webclient.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 方法调用信息Bean
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MethodInfo {

    /**
     * 请求url
     */
    private String url;

    /**
     * 请求方法【GET,POST,PUT,DELETE】
     */
    private HttpMethod method;


    /**
     * 请求参数(url)
     */
    private Map<String,Object> params;

    /**
     * 请求body
     */
    private Mono<?> body;
}
