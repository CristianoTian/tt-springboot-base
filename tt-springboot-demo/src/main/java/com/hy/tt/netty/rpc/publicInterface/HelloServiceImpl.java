package com.hy.tt.netty.rpc.publicInterface;

import com.hy.tt.netty.rpc.publicInterface.HelloService;

/**
 * @auther thy
 * @date 2019/11/29
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        return "I am fine,Thank you";
    }
}
