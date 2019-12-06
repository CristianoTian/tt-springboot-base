package com.hy.tt.apiAccessLimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther thy
 * @date 2019/12/6
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private  AccessLimitInterceptor accessLimitInterceptor;

    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessLimitInterceptor);
    }
}
