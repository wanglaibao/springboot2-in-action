package com.laibao.spring.reactive.routerfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootConfiguration
public class SpringBootMongodbReactiveRouterFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbReactiveRouterFunctionApplication.class,args);
    }
}
