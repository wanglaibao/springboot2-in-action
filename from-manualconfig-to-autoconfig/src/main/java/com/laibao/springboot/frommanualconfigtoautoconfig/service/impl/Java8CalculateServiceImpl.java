package com.laibao.springboot.frommanualconfigtoautoconfig.service.impl;

import com.laibao.springboot.frommanualconfigtoautoconfig.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * java8 lambda 实现{@link CalculateService}
 */
@Profile("java8")
@Service
public class Java8CalculateServiceImpl implements CalculateService {

    @Override
    public int sum(Integer... vararg) {
        System.out.println("java8 lambda 实现");
        //return Stream.of(vararg).reduce(0,Integer::sum);
        return Stream.of(vararg).reduce(0,(sum,element) -> sum + element);
    }

//    public static void main(String[] args) {
//        CalculateService calculateService = new Java8CalculateServiceImpl();
//        int sum = calculateService.sum(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("the sum is "+sum);
//    }
}
