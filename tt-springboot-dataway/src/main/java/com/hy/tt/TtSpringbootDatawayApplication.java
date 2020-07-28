package com.hy.tt;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHasor
@EnableHasorWeb
@SpringBootApplication
public class TtSpringbootDatawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootDatawayApplication.class, args);
    }

}
