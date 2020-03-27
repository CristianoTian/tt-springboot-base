package com.hy.tt;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2020/3/25
 */
@Component
public class MyErrorPageRegistrar implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //指定具体异常的错误定制页面
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
        registry.addErrorPages(e404);
    }
}
