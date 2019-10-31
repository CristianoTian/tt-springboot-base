package com.hy.tt.mode.strategy.controller;

import com.hy.tt.mode.strategy.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther thy
 * @date 2019/9/20
 */
@RestController
@RequestMapping("strategy")
public class Test {

    @Autowired
    private HelloServiceImpl helloService;

    @GetMapping("/sya")
    public String say(@RequestParam String num){
        String say = helloService.say(num);
        return say;
    }
}
