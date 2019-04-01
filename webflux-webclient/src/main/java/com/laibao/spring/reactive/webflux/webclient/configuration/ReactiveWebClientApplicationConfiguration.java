package com.laibao.spring.reactive.webflux.webclient.configuration;

import com.laibao.spring.reactive.webflux.webclient.api.IUserApi;
import com.laibao.spring.reactive.webflux.webclient.interfaces.ProxyCreator;
import com.laibao.spring.reactive.webflux.webclient.proxy.JDKProxyCreator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReactiveWebClientApplicationConfiguration {

    @Bean
    public ProxyCreator jdkProxyCreator() {
        return new JDKProxyCreator();
    }

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

}
