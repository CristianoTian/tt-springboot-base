package com.hy.tt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hy.tt.mapper")
public class TtSpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootMybatisApplication.class, args);
    }

}
