package com.hy.tt.demo.action;

import com.hy.tt.demo.service.HelloService;
import com.hy.tt.framework.annotation.TTAutowired;
import com.hy.tt.framework.annotation.TTController;
import com.hy.tt.framework.annotation.TTRequestMapping;

/**
 * @auther thy
 * @date 2019/11/1
 */
@TTController
@TTRequestMapping("/test")
public class TestAction {

    @TTAutowired
    private HelloService helloService;

    @TTRequestMapping("/hello")
    public String test(){
        String say = helloService.say();
        System.out.println(say);
        System.out.println("hello spring framework test");
        return "hello spring framework test";
    }
}
