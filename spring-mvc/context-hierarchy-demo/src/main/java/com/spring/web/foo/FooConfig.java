package com.spring.web.foo;


import com.spring.web.context.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class FooConfig {

    @Bean
    public TestBean testBeanX() {
        return new TestBean("fooX");
    }

    @Bean
    public TestBean testBeanY() {
        return new TestBean(("fooY"));
    }

    @Bean
    public FooAspect fooAspect() {
        return new FooAspect();
    }
}
