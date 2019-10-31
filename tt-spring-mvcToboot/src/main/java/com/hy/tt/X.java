package com.hy.tt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @auther thy
 * @date 2019/10/31
 */
@Component
public class X {

    public X() {
        System.out.println("init con X");
    }

    @PostConstruct
    public void afterPropertiesSet(){
        System.out.println("init X......");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy X.........");
    }

}
