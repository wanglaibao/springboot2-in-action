package com.laibao.springboot.frommanualconfigtoautoconfig.bootstrap;

import com.laibao.springboot.frommanualconfigtoautoconfig.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性引导类
 */
//@ConditionalOnSystemProperty(name = "user.name",value = "金戈")
public class ConditionalOnSystemPropertyBootStrap {


    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "A")
    public String helloWorld() {
        return "hello world,金戈";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext configApplicationContext = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //通过名称和类型获取 helloWorld Bean
        String helloWorld = configApplicationContext.getBean("helloWorld",String.class);
        System.out.println("helloWorld Bean is "+helloWorld);

        //关闭上下文
        configApplicationContext.close();
    }
}
