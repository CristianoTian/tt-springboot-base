package com.hy.tt.spring.mybatis.controller;

import com.hy.tt.spring.mybatis.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther thy
 * @date 2019/9/29
 */
@RestController
public class MyTTest {

    @Autowired
    public TService tService;

    @RequestMapping("mybatis/test")
    public String test(){
        tService.query();
        tService.query();
        return  "1";
    }
}
