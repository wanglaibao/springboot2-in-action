package com.laibao.springboot.frommanualconfigtoautoconfig.annotation;

import com.laibao.springboot.frommanualconfigtoautoconfig.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 激活HelloWorld模块
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {}
