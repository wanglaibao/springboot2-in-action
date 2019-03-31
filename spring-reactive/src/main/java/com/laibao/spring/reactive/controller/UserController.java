package com.laibao.spring.reactive.controller;

import com.laibao.spring.reactive.domain.User;
import com.laibao.spring.reactive.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 查询所有用户
     * 以数组形式一次性返回全部数据
     * @return
     */
    @GetMapping("/")
    public Flux<User> getAllUser() {
        return  userRepository.findAll();
    }

    /**
     * 查询所有用户
     * 以SSE形式多次返回数据
     * @return
     */
    @GetMapping(value = "/stream/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getAllUserBySSE() {
        return userRepository.findAll();
    }


    /**
     * 新增一条用户记录
     * @param user
     * @return
     */
    @PostMapping("/")
    public Mono<User> createUser(@RequestBody User user) {
        //spring data jpa里面新增和修改都是save方法
        //有ID的情况下是修改ID为空时新增
        //根据实际情况是否设置空ID
        user.setId(null);
        return userRepository.save(user);
    }

    /**
     * 根据ID删除一条用户记录
     * 存在的时候返回200 不存在的时候返回404
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id) {
        // deleteById(id)没有返回值  不能判断数据是否存在所以不能直接使用
        //return this.userRepository.deleteById(id);
        return userRepository.findById(id)
        //当我们要操作数据的时候并且返回一个Mono，这个时候要使用flatMap
        //如果不操作数据，只是转换数据，就使用map
                        .flatMap(user -> this.userRepository.delete(user).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                        .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
}
