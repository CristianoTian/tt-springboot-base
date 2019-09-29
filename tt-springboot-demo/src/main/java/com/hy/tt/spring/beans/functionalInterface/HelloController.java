package com.hy.tt.spring.beans.functionalInterface;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther thy
 * @date 2019/9/27
 */
@RestController
public class HelloController {

    /**
     * 函数式 实现接口测试
     */
    @RequestMapping("/functionalInterface/test")
    public void test(){
        IHelloService greetService1 = aaaa -> System.out.println("Hello " + aaaa);
        greetService1.say("txy");
    }
}
