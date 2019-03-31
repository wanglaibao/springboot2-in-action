package com.laibao.spring.reactive.routerfunction.handler;

import com.laibao.spring.reactive.routerfunction.domain.User;
import com.laibao.spring.reactive.routerfunction.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 获取所有的用户信息
     * @param request
     * @return
     */
    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        return ok()
                .contentType(APPLICATION_JSON_UTF8)
                .body(userRepository.findAll(), User.class);
    }

    /**
     * 创建一个新用户
     * @param request
     * @return
     */
    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ok()
                .contentType(APPLICATION_JSON_UTF8)
                .body(userRepository.saveAll(userMono), User.class);
    }


    /**
     * 根据ID来删除一个用户
     * @param request
     * @return
     */
    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        String userId = request.pathVariable("id");
        return userRepository.findById(userId)
                                .flatMap(user -> userRepository.delete(user).then(ok().build()))
                                .switchIfEmpty(notFound().build());
    }


    /**
     * 更新一个用户
     * @param request
     * @return
     */
    public Mono<ServerResponse> updateUser(ServerRequest request) {
        String userId = request.pathVariable("id");
        Mono<User> userMono = request.bodyToMono(User.class);
        User originalUser  = userMono.block();
        return userRepository.findById(userId)
                .flatMap(user -> {
                        user.setAge(originalUser.getAge());
                        user.setName(originalUser.getName());
                        return this.userRepository.save(originalUser).then(ok().build());
                })
                .switchIfEmpty(notFound().build());
    }
}
