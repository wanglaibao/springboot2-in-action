package com.laibao.springboot.frommanualconfigtoautoconfig.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Java 系统属性 条件判断
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * java 属性名称
     * @return
     */
    String name();

    /**
     * java 系统属性值
     * @return
     */
    String value();


}
