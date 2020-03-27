package com.hy.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TtSpringbootExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootExceptionApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        throw new TTException("521","对不起我爱你");
    }

    @RequestMapping("/normal")
    public String normal() throws Exception {
        throw new Exception("521");
    }
}
