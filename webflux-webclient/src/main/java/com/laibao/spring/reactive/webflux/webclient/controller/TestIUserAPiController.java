package com.laibao.spring.reactive.webflux.webclient.controller;

import com.laibao.spring.reactive.webflux.webclient.api.IUserApi;
import com.laibao.spring.reactive.webflux.webclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        //测试信息提取
        //不订阅不会实际发出请求，但是会进入我们的代理类
        userApi.getAllUser();
        userApi.getUserById("1111111111");
        userApi.deleteUserById("222222222");
        userApi.createUser(Mono.just(User.builder().name("金戈").age(10000).build()));

        //直接调用  实现类似调用REST接口的效果
        //Flux<User> userFlux = userApi.getAllUser();
        //userFlux.subscribe(System.out::println);
    }
}
