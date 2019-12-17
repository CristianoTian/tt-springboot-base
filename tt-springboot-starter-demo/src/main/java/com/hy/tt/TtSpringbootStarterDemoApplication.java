package com.hy.tt;

import com.hy.ttt.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TtSpringbootStarterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSpringbootStarterDemoApplication.class, args);
    }

    @Autowired
    private StarterHelloService starterHelloService;

    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    private String index(){
        String a = "123";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        String encode = bCryptPasswordEncoder.encode(a);
        System.out.println(encode);
        boolean matches = bCryptPasswordEncoder.matches("123", encode);
        System.out.println(matches);
        boolean matches1 = bCryptPasswordEncoder.matches("1234", encode);
        System.out.println(matches1);
        return   demoService.getObject();

//        return starterHelloService.getName() + starterHelloService.getHobby();

    }
}
