package com.demo.springdemo.anno;

import com.demo.springdemo.SpringDemoApplicationTests;
import org.junit.Test;
import java.lang.reflect.Method;

public class ForumServiceTest extends SpringDemoApplicationTests {

    @Test
    public void tool() {
        // 1.得到 ForumService 对应的 Class 对象
        Class clazz = ForumService.class;

        // 2.得到 ForumService 对应的 Method 数组
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            // 3.获取方法上所标注的注解对象
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}