package com.laibao.springboot.frommanualconfigtoautoconfig.repository;

import com.laibao.springboot.frommanualconfigtoautoconfig.annotation.FirstLevelRepository;

@FirstLevelRepository(value = "myFirstRepository") // Bean 名称
public class MyFirstRepository {
}
