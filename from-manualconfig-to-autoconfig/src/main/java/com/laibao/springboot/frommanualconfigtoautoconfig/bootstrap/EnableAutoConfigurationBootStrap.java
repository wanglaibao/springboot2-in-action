package com.laibao.springboot.frommanualconfigtoautoconfig.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration}引导类
 */

@EnableAutoConfiguration
public class EnableAutoConfigurationBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext configApplicationContext = new SpringApplicationBuilder(EnableAutoConfigurationBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //helloWorld Bean 是否存在
        String helloWorld = configApplicationContext.getBean("helloWorld",String.class);

        System.out.println("helloWorld Bean "+helloWorld);

        //关闭上下文
        configApplicationContext.close();
    }
}
