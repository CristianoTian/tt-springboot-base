package com.hy.tt.https;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther thy
 * @date 2019/9/26
 */
@RestController
@RequestMapping("/testHttps")
public class TestHttpsController {

    @RequestMapping("/get")
    public String get(){
        return "hello https!";
    }
}
