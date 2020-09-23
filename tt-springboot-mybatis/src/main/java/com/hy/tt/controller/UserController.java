package com.hy.tt.controller;

import com.hy.tt.entity.User;
import com.hy.tt.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thy
 * @date 2020/9/22
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public User get(@RequestParam("id") Long id){
        User user = userService.getById(id);
        return user;
    }
}
