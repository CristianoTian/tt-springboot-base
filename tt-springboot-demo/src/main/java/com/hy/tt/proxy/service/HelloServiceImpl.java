package com.hy.tt.proxy.service;

/**
 * @auther thy
 * @date 2019/9/25
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String say(String name) {
        System.out.println("===== use HelloServiceImpl.say() method ======");
        return name;
    }
}
