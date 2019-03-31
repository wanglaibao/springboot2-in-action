package com.laibao.spring.reactive.routerfunction.router;

import com.laibao.spring.reactive.routerfunction.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions.nest(RequestPredicates
                                             //相当于类上面的 @RequestMapping("/user")
                                            .path("/user"),
                                                        // 相当于类里面的  @GetMapping("/") 获取所有用户信息
                                                        RouterFunctions.route(RequestPredicates.GET("/"),userHandler::getAllUsers)
                                                        //创建一个新用户
                                                        .andRoute(RequestPredicates.POST("/").and(accept(MediaType.APPLICATION_JSON_UTF8))  ,userHandler::createUser)
                                                        //更新一个用户信息
                                                        .andRoute(RequestPredicates.PUT("/{id}").and(accept(MediaType.APPLICATION_JSON_UTF8)),userHandler::updateUser)
                                                        //删除一个用户信息
                                                        .andRoute(RequestPredicates.DELETE("/{id}"),userHandler::deleteUser)
                );
    }
}
