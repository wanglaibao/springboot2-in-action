package com.laibao.springboot.frommanualconfigtoautoconfig.service;

public interface CalculateService {
    /**
     * 从多个整数中求和
     * @param vararg
     * @return int
     */
    int sum(Integer... vararg);
}
