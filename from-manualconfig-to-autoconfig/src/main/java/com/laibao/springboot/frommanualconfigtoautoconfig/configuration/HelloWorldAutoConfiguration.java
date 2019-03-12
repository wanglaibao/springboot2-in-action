package com.laibao.springboot.frommanualconfigtoautoconfig.configuration;

import com.laibao.springboot.frommanualconfigtoautoconfig.annotation.EnableHelloWorldBySelecter;
import com.laibao.springboot.frommanualconfigtoautoconfig.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 *  HelloWorld 自动装配
 */
@Configuration     // Spring 模式注解
@EnableHelloWorldBySelecter //Spring @Enalbe 模块装配
@ConditionalOnSystemProperty(name = "user.name",value = "A") //条件装配
public class HelloWorldAutoConfiguration {
}
