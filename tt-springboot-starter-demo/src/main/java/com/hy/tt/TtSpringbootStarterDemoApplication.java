package com.hy.tt;

import com.hy.ttt.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
      return   demoService.getObject();

//        return starterHelloService.getName() + starterHelloService.getHobby();
    }
}
