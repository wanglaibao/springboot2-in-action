package com.laibao.spring.reactive.model;

public class Dog {

    private String name ="哮天犬";

    private int foodNumber = 1000;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    /**
     * 静态方法
     * @param dog
     */
    public static void bark(Dog dog) {
        System.out.println(dog+"叫了啊");
    }

    /**
     * JDK默认会把当前实例this传入到非静态方法【实例方法中】,参数名称为this,位置是方法参数中的第一个，切记切记
     * @param num
     * @return
     */
    public int eat(Dog this,int num) {
        System.out.println("吃了 "+num+"斤");
        return this.foodNumber - num;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
