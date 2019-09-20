package com.hy.tt.strategyMode.config;

import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/9/20
 */
@Component
@NumType("2")
public class SecondHandler  extends AbstractHello{

    @Override
    public String say(String num) {
        return "second";
    }
}
