package com.laibao.springboot.frommanualconfigtoautoconfig.service.impl;

import com.laibao.springboot.frommanualconfigtoautoconfig.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * java7 for 循环实现{@link CalculateService}
 */

@Profile("java7")
@Service
public class Java7CalculateServiceImpl implements CalculateService {

    @Override
    public int sum(Integer... vararg) {
        int sum = 0;
        for (Integer intNumber:vararg) {
            sum += intNumber;
        }
        return sum;
    }


//    public static void main(String[] args) {
//        CalculateService calculateService = new Java7CalculateServiceImpl();
//        int sum = calculateService.sum(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("the sum is "+sum);
//    }
}
