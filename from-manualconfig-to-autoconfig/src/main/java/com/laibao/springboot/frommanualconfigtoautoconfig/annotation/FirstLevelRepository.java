package com.laibao.springboot.frommanualconfigtoautoconfig.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    String value() default "";
}
