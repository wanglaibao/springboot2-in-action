package com.laibao.spring.reactive;

import com.laibao.spring.reactive.simpleexample.MyMoney;

import java.text.DecimalFormat;

public class MoneyFormatDemo {
    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(123123);
        myMoney.printMoney(i -> new DecimalFormat("#,###").format(i));
    }
}
