package com.laibao.spring.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableReactiveMongoRepositories
public class SpringBootMongodbReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbReactiveApplication.class,args);
    }
}
