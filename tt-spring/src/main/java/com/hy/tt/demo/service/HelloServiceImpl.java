package com.hy.tt.demo.service;

import com.hy.tt.framework.annotation.TTService;

/**
 * @auther thy
 * @date 2019/11/1
 */
@TTService
public class HelloServiceImpl implements HelloService{
    public String say() {
        return "service say";
    }
}
