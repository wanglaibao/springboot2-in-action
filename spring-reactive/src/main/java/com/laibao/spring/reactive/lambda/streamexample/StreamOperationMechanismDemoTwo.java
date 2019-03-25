package com.laibao.spring.reactive.lambda.streamexample;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 验证Stream的运行机制
 * 深刻理解Stream的原理
 * 以便更好的使用
 */
public class StreamOperationMechanismDemoTwo {
    /**
     *  惰性求值
     *          中间操作：返回流的操作
     *              1：无状态的中间操作
     *              2：有状态的中间操作
     *              3: parallel(); sequential() 不创建流【Stream】，他们只是修改Head的parallel【并行】标志
     *          终止操作
     *   收集器 -->    分区 和 分组
     *
     *   运行机制
     *        1：链式调用的  Head -> nextStage -> nextStage -> nextStage -> ....-> null
     *        2：并行 fork/join
     */

    /**
     *  区分中间操作是无状态还是有状态的小技巧：
     *  1：无状态的中间操作入参基本上是一个参数
     *  2：有状态的中间操作入参基本上是两个参数或者两个以上参数
     */

    /**
     *  1:所有操作都是链式调用的，每一个元素之迭代一次
     *  2:每一个中间操作都返回一个新的Stream，Stream里面有一个属性sourceStage，这个sourceStage指向同一个地方就是【链表的头】 ReferencePipeline Head
     *  3:Head -> nextStage -> nextStage -> nextStage -> ....-> null
     *  4:当无状态操作中间夹杂了有状态操作的时候，有状态操作会把无状态操作截断，单独处理
     *  5:并行情况下，无状态的中间操作是多线程操作的，但是有状态的中间操作不一定是多线程的【一般情况下是单线程的】
     *  6: parallel(); sequential() 这两个操作也是中间操作，但是他们不创建流【Stream】，他们只是修改Head的parallel【并行】标志
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
                })
                // 夹杂有状态操作
                .sorted((intValue1,intValue2) -> intValue1.compareTo(intValue2))
                //后面跟上另外一个无状态操作
                .peek(intValue -> System.err.println("peek2: "+intValue))
                // 测试并行条件下的运行情况
                .parallel();

        //终止操作
        stream.count();
    }
}
