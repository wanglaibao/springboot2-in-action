package com.laibao.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan(basePackages = "com.laibao.springboot.web.servlet")
public class SimpleServletAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleServletAppApplication.class, args);
	}
}
