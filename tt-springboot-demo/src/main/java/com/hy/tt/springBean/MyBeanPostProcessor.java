package com.hy.tt.springBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/9/25
 */
@Configuration("beanPostProcessor")
public class MyBeanPostProcessor implements BeanPostProcessor {


    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor 构造");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor ------------- postProcessBeforeInitialization() :" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor ------------- postProcessAfterInitialization() :" + beanName);
        return bean;
    }
}
