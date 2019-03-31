package com.laibao.spring.reactive.repository;

import com.laibao.spring.reactive.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String>{

    /**
     *  根据年龄端来查询用户信息
     * @param start
     * @param end
     * @return
     */
    Flux<User> findUserByAgeBetween(int start,int end);
}
