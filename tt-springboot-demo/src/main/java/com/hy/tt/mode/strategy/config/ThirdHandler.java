package com.hy.tt.mode.strategy.config;

import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/9/20
 */
@Component
@NumType("3")
public class ThirdHandler extends AbstractHello {
    @Override
    public String say(String num) {
        return "Third";
    }
}
