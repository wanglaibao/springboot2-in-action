package com.laibao.spring.reactive.webflux.webclient;

import com.laibao.spring.reactive.webflux.webclient.api.IUserApi;
import com.laibao.spring.reactive.webflux.webclient.interfaces.ProxyCreator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootReactiveWebClientApplication {

    @Bean
    public FactoryBean<IUserApi> userApi(ProxyCreator proxyCreator) {

        return new FactoryBean<IUserApi>() {
            /**
             * 返回代理对象
             * 具体实现由JDK动态代理来实现
             * @return IUserApi
             * @throws Exception
             */
            @Override
            public IUserApi getObject() throws Exception {
                return (IUserApi)proxyCreator.createProxy(getObjectType());
            }

            @Override
            public Class<?> getObjectType() {
                return IUserApi.class;
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactiveWebClientApplication.class,args);
    }
}
