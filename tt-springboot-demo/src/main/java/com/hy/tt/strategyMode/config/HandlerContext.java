package com.hy.tt.strategyMode.config;

import com.hy.tt.strategyMode.util.BeanTool;

import java.util.Map;

/**
 * @auther thy
 * @date 2019/9/20
 */
@SuppressWarnings("unchecked")
public class HandlerContext {

    private Map<String ,Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHello getInstance(String type) {
        Class aClass = handlerMap.get(type);
        if(aClass == null){
            throw  new IllegalArgumentException("not found handler for type: " + type);
        }
        return (AbstractHello) BeanTool.getBean(aClass);
    }
}
