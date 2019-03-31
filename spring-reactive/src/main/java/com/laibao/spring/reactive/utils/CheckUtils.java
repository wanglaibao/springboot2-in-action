package com.laibao.spring.reactive.utils;

import com.laibao.spring.reactive.exceptions.CheckException;

import java.util.stream.Stream;

public class CheckUtils {

    private static final String[] INVALIDATE_NAMES = {"admin","guanliyuan"};

    /**
     *  校验名称不成功就抛出运行时异常
     * @param originalName
     */
    public static void checkUserName(String originalName) {
        Stream.of(INVALIDATE_NAMES)
                .filter(name -> name.equalsIgnoreCase(originalName))
                .findAny()
                .ifPresent(name -> {
                    throw new CheckException("name",originalName);
                });
    }
}
