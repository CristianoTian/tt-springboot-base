package com.hy.tt.mode.strategy.config;

import com.hy.tt.mode.strategy.util.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther thy
 * @date 2019/9/20
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcesser implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE ="com.hy.tt.mode.strategy.config";
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String ,Class> handlerMap = new HashMap<>();
        ClassScaner.scan(HANDLER_PACKAGE, NumType.class).forEach(clazz -> {
            // 获取注解中的类型值
            String type = clazz.getAnnotation(NumType.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存在Map中
            handlerMap.put(type, clazz);
        });
        // 初始化HandlerContext，将其注册到spring容器中
        HandlerContext context = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }
}
