package com.laibao.springboot.springboot2inaction.helloapp.controller;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by A on 2018/3/7.
 */
public class LazyOne {

    private static LazyOne instance;

    private static ReentrantLock lock = new ReentrantLock();
    private LazyOne(){}

    public static LazyOne getInstance() {
        lock.lock();
        try{
            if (instance == null) {
                instance = new LazyOne();
            }
            return instance;
        }finally {
            lock.unlock();
        }
    }
}
