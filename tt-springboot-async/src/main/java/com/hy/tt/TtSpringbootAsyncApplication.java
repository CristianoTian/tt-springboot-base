package com.hy.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TtSpringbootAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootAsyncApplication.class, args);
    }

}
