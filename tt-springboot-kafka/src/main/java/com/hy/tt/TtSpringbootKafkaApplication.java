package com.hy.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TtSpringbootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootKafkaApplication.class, args);
    }

}
