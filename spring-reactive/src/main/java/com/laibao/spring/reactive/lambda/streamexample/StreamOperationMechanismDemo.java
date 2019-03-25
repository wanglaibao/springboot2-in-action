package com.laibao.spring.reactive.lambda.streamexample;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * 验证Stream的运行机制
 * 深刻理解Stream的原理
 * 以便更好的使用
 *
 * 该案例演示 的中间操作都是无状态的
 */
public class StreamOperationMechanismDemo{

    /**
     *  1:所有操作都是链式调用的，每一个元素之迭代一次
     *  2:每一个中间操作都返回一个新的Stream，Stream里面有一个属性sourceStage，这个sourceStage指向同一个地方就是【链表的头】 ReferencePipeline Head
     *  3:Head -> nextStage -> nextStage -> nextStage -> ....-> null
     *
     */

    public static void main(String[] args) {

        Random random = new Random();

        //随机产生整形数据流【无限流】
        Stream<Integer> stream  = Stream.generate(() -> random.nextInt())
                //截取1000个
                .limit(1000)
                //第一个无状态操作
                .peek(intValue -> System.err.println("peek: "+intValue))
                //第二个无状态操作
                .filter(intValue -> {
                    System.err.println("filter: "+intValue);
                    return intValue > 1000000;
                });

                //终止操作
                stream.count();
    }
}
