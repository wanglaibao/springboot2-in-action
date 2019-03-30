package com.laibao.spring.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringBootMongodbReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbReactiveApplication.class,args);
    }
}
