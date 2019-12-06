package com.hy.tt.apiAccessLimit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther thy
 * @date 2019/12/6
 */
@RestController
public class TestController {

    @AccessLimit(seconds = 5,maxCount = 5,needLogin = false)
    @RequestMapping("/test")
    public String get(){
        return "";
    }
}
