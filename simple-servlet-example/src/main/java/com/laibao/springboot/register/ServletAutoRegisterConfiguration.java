package com.laibao.springboot.register;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
@ServletComponentScan(basePackages = "com.laibao.springboot.web.servlet")
@Configuration
public class ServletAutoRegisterConfiguration {
}
