package com.hy.ttt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther thy
 * @date 2019/12/12
 */
@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(prefix = "tt.demo", value = "enabled", matchIfMissing = true)
public class DemoServiceAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;


    @Bean
    @ConditionalOnMissingBean(DemoService.class)
    public DemoService demoService(){
        DemoService demoService = new DemoService(demoProperties);
        return demoService;
    }
}
