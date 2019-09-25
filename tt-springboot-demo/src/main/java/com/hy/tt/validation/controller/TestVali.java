package com.hy.tt.validation.controller;

import com.hy.tt.validation.dto.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @auther thy
 * @date 2019/9/23
 */
@RestController
@RequestMapping("validation")
public class TestVali {

    @PostMapping("/check")
    public String check(@RequestBody @Validated Student student){
        return "0";
    }
}
