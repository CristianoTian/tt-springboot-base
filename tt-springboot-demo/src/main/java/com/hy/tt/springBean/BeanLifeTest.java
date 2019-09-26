package com.hy.tt.springBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther thy
 * @date 2019/9/25
 */
public class BeanLifeTest {
    public static void main(String[] args) {
        System.out.println("开始初始化容器");
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:beans.xml");
        System.out.println("容器初始化成功");
        Hello hello = factory.getBean("hello", Hello.class);
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }

    /*
    开始初始化容器
    MyBeanFactoryPostProcessor 构造
    BeanFactoryPostProcessor ------------- postProcessBeanFactory()
    MyBeanPostProcessor 构造
    MyInstantiationAwareBeanPostProcessor 构造
    InstantiationAwareBeanPostProcessor ------------- postProcessBeforeInstantiation()
    hello 构造
    InstantiationAwareBeanPostProcessor ------------- postProcessAfterInstantiation()
    InstantiationAwareBeanPostProcessor ------------- postProcessProperties()
    InstantiationAwareBeanPostProcessor ------------- postProcessPropertyValues()
    BeanNameAware -------------  setBeanName()
    BeanFactoryAware -------------  setBeanFactory()
    BeanPostProcessor ------------- postProcessBeforeInitialization() :hello
    InitializingBean -------------  afterPropertiesSet()
    【init-method】调用<bean>的init-method属性指定的初始化方法
    BeanPostProcessor ------------- postProcessAfterInitialization() :hello
    容器初始化成功
    现在开始关闭容器！
    DisposableBean -------------  destroy()
    【destroy-method】调用<bean>的destroy-method属性指定的初始化方法


     */
}



/*
1.BeanFactoryPostProcessor -- postProcessorBeanFactory()
2.InstantiationAwareBeanPostProcessor -- before()
3.初始化
4.InstantiationBeanPostProcessor -  postProcessorAfterInstantiation()
5.InstantiationBeanPostProcessor -  postProcessorPropertyValues()
6.设置属性
7.BeanNameAware - setBeanName()
8.BeanFactoryAware - setBeanFactory()
9.ApplicationContextAware - setApplicationContext()
10.BeanPostProcessor - postProcessorBeforeInitialization()
11.InitializingBean - afterPropertiesSet()
12.init-method()
13.BeanPostProcessor - postProcessorAfterInitialization()
14.DisposableBean - destroy()
15.destroy-method()
 */

