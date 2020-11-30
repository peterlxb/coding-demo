package com.demo.springdemo.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFactoryBean implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf)
            throws BeansException {

        // 1.将 ConfigurableListableBeanFactory 转化为 DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) bf;

        // 2.通过 BeanDefinitionBuilder 创建 Bean 定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);

        // 3.设置属性 userDao，此属性引用已经定义的 bean:userDao
        beanDefinitionBuilder.addPropertyReference("userDao","userDao");

        // 4.注册 bean 定义
        beanFactory.registerBeanDefinition("userService1",
                beanDefinitionBuilder.getRawBeanDefinition());

        // 5.直接注册一个 Bean 实例
        beanFactory.registerSingleton("userService2",new UserService());
    }
}
