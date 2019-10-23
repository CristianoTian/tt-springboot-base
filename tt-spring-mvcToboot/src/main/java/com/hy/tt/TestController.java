package com.hy.tt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther thy
 * @date 2019/10/23
 */
@Controller
public class TestController {

    @RequestMapping("/index.do")
    public void index(){
        System.out.println("index");
    }
}
