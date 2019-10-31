package com.hy.tt.mode.strategy.service;

import com.hy.tt.mode.strategy.config.AbstractHello;
import com.hy.tt.mode.strategy.config.HandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther thy
 * @date 2019/9/20
 */
@Service
public class HelloService implements HelloServiceImpl {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String say(String num) {
        AbstractHello instance = handlerContext.getInstance(num);
        return instance.say(num);
    }

//    @Override
//    public String say(Integer num) {
//        if("1".equals(num)){
//            return "first";
//        }else if ("2".equals(num)){
//            return "second";
//        }else if ("3".equals(num)){
//            return "third";
//        }
//        return null;
//    }
}
