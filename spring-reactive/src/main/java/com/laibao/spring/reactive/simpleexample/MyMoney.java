package com.laibao.spring.reactive.simpleexample;

import com.laibao.spring.reactive.functionalinterface.IMoneyFormat;

import java.util.function.Function;

public class MyMoney {

    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

//    public void printMoney(IMoneyFormat iMoneyFormat) {
//        System.out.println("我的存款金额是: " + iMoneyFormat.format(money));
//    }

    public void printMoney(Function<Integer,String> iMoneyFormat) {
        System.out.println("我的存款金额是: " + iMoneyFormat.apply(money));
    }
}
