package com.laibao.springboot.frommanualconfigtoautoconfig.repository;

import com.laibao.springboot.frommanualconfigtoautoconfig.annotation.SecondLevelRepository;

@SecondLevelRepository(value = "mySecondRepository")
//@Component(value = "mySecondRepository")
public class MySecondRepository {
}
