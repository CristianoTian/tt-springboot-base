package com.hy.tt.springBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.Configuration;

/**
 * @auther thy
 * @date 2019/9/25
 *
 * 首先是一个简单的Spring Bean，调用Bean自身的方法和Bean级生命周期接口方法，为了方便演示，
 * 它实现了BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这4个接口，
 * 同时有2个方法，对应配置文件中<bean>的init-method和destroy-method。如下：
 */
@Configuration
public class Hello implements InitializingBean, DisposableBean, BeanFactoryAware , BeanNameAware {


    private String name ;

    private BeanFactory beanFactory;
    private String beanName;

    public Hello() {
        System.out.println("hello 构造");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean -------------  afterPropertiesSet()");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean -------------  destroy()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware -------------  setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware -------------  setBeanName()");
        this.beanName = name;
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
