package com.laibao.spring.reactive;

import com.laibao.spring.reactive.simpleexample.MyMoney;

import java.text.DecimalFormat;
import java.util.function.Function;

public class MoneyFormatDemo {
    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(123123);
        Function<Integer,String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
        // 函数式接口还可以支持链式操作
        myMoney.printMoney(moneyFormat.andThen(str -> "人民币"+str));
    }
}
