package com.laibao.springboot.frommanualconfigtoautoconfig.bootstrap;

import com.laibao.springboot.frommanualconfigtoautoconfig.FromManualconfigToAutoconfig;
import com.laibao.springboot.frommanualconfigtoautoconfig.repository.MyFirstRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Repository 的引导类
 */
//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.laibao.springboot.frommanualconfigtoautoconfig.repository")
public class RepositoryBootStrap {

    public static void main(String[] args) {
        //SpringApplication.run(FromManualconfigToAutoconfig.class, args);
        ConfigurableApplicationContext configApplicationContext = new SpringApplicationBuilder(RepositoryBootStrap.class)
                                                                                .web(WebApplicationType.NONE)
                                                                                .run(args);

        MyFirstRepository myFirstRepository = configApplicationContext.getBean("myFirstRepository",MyFirstRepository.class);

        System.out.println("myFirstRepository Bean "+myFirstRepository)
        ;
        configApplicationContext.close();
    }
}
