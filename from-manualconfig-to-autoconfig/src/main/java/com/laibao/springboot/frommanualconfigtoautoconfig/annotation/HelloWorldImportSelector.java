package com.laibao.springboot.frommanualconfigtoautoconfig.annotation;

import com.laibao.springboot.frommanualconfigtoautoconfig.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld{@link ImportSelector} 实现
 *
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
