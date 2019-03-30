package com.laibao.spring.reactive.repository;

import com.laibao.spring.reactive.domain.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String>{
}
