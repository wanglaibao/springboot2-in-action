package com.laibao.springboot.frommanualconfigtoautoconfig.bootstrap;

import com.laibao.springboot.frommanualconfigtoautoconfig.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableHelloWorld} 引导类
 */
@EnableHelloWorld
public class EnableHelloWorldBootStrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configApplicationContext = new SpringApplicationBuilder(EnableHelloWorldBootStrap.class)
                                                                                  .web(WebApplicationType.NONE)
                                                                                  .run(args);
        //helloWorld Bean 是否存在
        String helloWorld = configApplicationContext.getBean("helloWorld",String.class);

        System.out.println("helloWorld Bean "+helloWorld);
        //关闭上下文
        configApplicationContext.close();
    }
}
