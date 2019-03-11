package com.laibao.springboot.frommanualconfigtoautoconfig.bootstrap;

import com.laibao.springboot.frommanualconfigtoautoconfig.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link CalculateService} 引导类
 */
@SpringBootApplication(scanBasePackages = "com.laibao.springboot.frommanualconfigtoautoconfig.service")
public class Java8CalculateServiceBootStrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configApplicationContext = new SpringApplicationBuilder(Java7CalculateServiceBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        // CalculateService Bean 是否存在 或者存在多个Bean矛盾
        // 在没有配置 .profiles("java8") 的情况下
        // Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.laibao.springboot.frommanualconfigtoautoconfig.service.CalculateService' available
        CalculateService calculateService = configApplicationContext.getBean(CalculateService.class);

        System.out.println("calculateService sum(1,2,3,4,5,6,7,8,9,10) is  "+calculateService.sum(1,2,3,4,5,6,7,8,9,10));
        //关闭上下文
        configApplicationContext.close();
    }
}
