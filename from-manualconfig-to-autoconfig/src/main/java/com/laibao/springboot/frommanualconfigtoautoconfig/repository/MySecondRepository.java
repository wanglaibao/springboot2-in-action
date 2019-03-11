package com.laibao.springboot.frommanualconfigtoautoconfig.repository;

import com.laibao.springboot.frommanualconfigtoautoconfig.annotation.SecondLevelRepository;
import org.springframework.stereotype.Component;

@SecondLevelRepository(value = "mySecondRepository")
//@Component(value = "mySecondRepository")
public class MySecondRepository {
}
