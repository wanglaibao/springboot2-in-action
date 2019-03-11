package com.laibao.springboot.frommanualconfigtoautoconfig.bootstrap;

import com.laibao.springboot.frommanualconfigtoautoconfig.repository.MyFirstRepository;
import com.laibao.springboot.frommanualconfigtoautoconfig.repository.MySecondRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Repository 的引导类
 */
@ComponentScan(basePackages = "com.laibao.springboot.frommanualconfigtoautoconfig.repository")
public class RepositoryBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext configApplicationContext = new SpringApplicationBuilder(RepositoryBootStrap.class)
                                                                                .web(WebApplicationType.NONE)
                                                                                .run(args);

        MyFirstRepository myFirstRepository = configApplicationContext.getBean("myFirstRepository",MyFirstRepository.class);

        System.out.println("myFirstRepository Bean "+myFirstRepository);
        System.out.println();

        MySecondRepository mySecondRepository = configApplicationContext.getBean("mySecondRepository",MySecondRepository.class);

        System.out.println("mySecondRepository Bean "+mySecondRepository);

        configApplicationContext.close();
    }
}
