package com.hy.tt;

import com.hy.tt.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TtSpringbootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootRedisApplication.class, args);
    }

}
