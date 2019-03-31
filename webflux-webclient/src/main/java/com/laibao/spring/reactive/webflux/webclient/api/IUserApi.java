package com.laibao.spring.reactive.webflux.webclient.api;

import com.laibao.spring.reactive.webflux.webclient.annotation.ApiServer;
import com.laibao.spring.reactive.webflux.webclient.domain.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@ApiServer("http://localhost:8080/user")
public interface IUserApi {

    /**
     * 查询所有用户
     */
    @GetMapping("/")
    Flux<User> getAllUser();

    /**
     * 新增一条用户记录
     */
    @PostMapping("/")
    Mono<User> createUser(@RequestBody User user);

    /**
     * 根据ID删除一条用户记录
     */
    @DeleteMapping("/{id}")
    Mono<Void> deleteUser(@PathVariable String id);

    /**
     * 根据ID来查询用户
     */
    @GetMapping("/{id}")
    Mono<User> getUserById(@PathVariable String id);
}


