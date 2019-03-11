package com.laibao.springboot.frommanualconfigtoautoconfig.repository;

import com.laibao.springboot.frommanualconfigtoautoconfig.annotation.FirstLevelRepository;
import org.springframework.context.annotation.Configuration;

@FirstLevelRepository(value = "myFirstRepository") // Bean 名称
public class MyFirstRepository {
}
