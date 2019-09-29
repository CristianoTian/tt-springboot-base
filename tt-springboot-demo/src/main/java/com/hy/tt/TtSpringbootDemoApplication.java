package com.hy.tt;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.hy.tt.spring.mybatis.dao")
public class TtSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootDemoApplication.class, args);
    }

}
