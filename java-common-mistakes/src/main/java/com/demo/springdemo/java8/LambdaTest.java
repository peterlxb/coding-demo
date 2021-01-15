package com.demo.springdemo.java8;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class LambdaTest {

    @Test
    public void lambdavsanonymousclass() {
        // 匿名类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello 1");
            }
        }).start();

        // Lambda 表达式
        new Thread(() -> System.out.println("Hello 2")).start();
    }

    @Test
    public void functionalInterfaces() {

        // java.util.function包
        // 使用 lambda 表达式提供Supplier 接口实现，返回 OK 字符串
        Supplier<String> StringSupplier = () -> "OK";

        // 使用方法引用提供 Supplier 接口实现，返回空字符串
        Supplier<String> suppier = String::new;

        // Predicate 接口输入一个参数，返回布尔值，这里通过 and 方法组合两个 Predicate 条件，判断是否大于0且是偶数
        Predicate<Integer> positiveNumber = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        assertTrue(positiveNumber.and(evenNumber).test(2));

        // Cousumer 是消费一个数据，通过 andThen 组合调用两个 Cousumer，输出两行 abcdefg
        Consumer<String> println = System.out::println;
        println.andThen(println).accept("abcdefg");

        // Function 接口是输入一个数据，计算后输出一个数据
        // 下面的例子先把字符串转为大写，然后通过 andThen 组合另一个 Function实现字符串拼接
        Function<String, String> upperCase = String::toUpperCase;
        Function<String,String> duplicate = s -> s.concat(s);
        assertThat(upperCase.andThen(duplicate).apply("test"), is("TESTTEST"));

        // Supplier 是提供一个数据的接口。下面实现一个随机数
        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(random.get());

        // BinaryOperator 是输入两个同类型参数，输出一个同类型参数的接口。
        // 这里通过方法引用获得一个整数加法操作，通过 lambda 表达式定义一个减法操作，然后依次调用。
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtrcation = (a, b) -> a - b;
        assertThat(subtrcation.apply(add.apply(1,2),3),is(0));
     }
}
