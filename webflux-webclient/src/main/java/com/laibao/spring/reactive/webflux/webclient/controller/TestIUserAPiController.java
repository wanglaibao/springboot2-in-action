package com.laibao.spring.reactive.webflux.webclient.controller;

import com.laibao.spring.reactive.webflux.webclient.api.IUserApi;
import com.laibao.spring.reactive.webflux.webclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 测试Controller用来测试IUserApi的功能
 */
@RestController
public class TestIUserAPiController {

    /**
     * 注入定义的接口 IUserApi
     */
    @Autowired
    private IUserApi userApi;

    @GetMapping("/")
    public void testIUserApi() {
        //直接调用  实现类似调用REST接口的效果
        Flux<User> userFlux = userApi.getAllUser();
        userFlux.subscribe(System.out::println);
    }
}
