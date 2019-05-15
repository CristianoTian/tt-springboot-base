package com.hy.tt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther thy
 * @date 2019/5/15
 */
@Configuration
@EnableConfigurationProperties(StarterHelloProperties.class)
@ConditionalOnClass(StarterHelloService.class)
@ConditionalOnProperty(prefix = "tt", value = "enabled", matchIfMissing = true)
public class StarterHelloAutoConfiguration {

    @Autowired
    private StarterHelloProperties starterHelloProperties;

    @Bean
    @ConditionalOnMissingBean(StarterHelloService.class)
    //当容器中没有此Bean的时候,创建此Bean(由于StarterHelloService 上没有注入容器,所以会在这里创建)
    //与类上的@ConditionalOnClass(StarterHelloService.class) 对应
    public StarterHelloService helloConfiguration() {
        StarterHelloService helloService = new StarterHelloService();
        helloService.setName(starterHelloProperties.getName());
        helloService.setHobby(starterHelloProperties.getHobby());
        return helloService;
    }
}
