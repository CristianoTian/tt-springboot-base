package com.hy.tt;

import com.hy.tt.rabbitMq.RabbitSender;
import com.hy.tt.rabbitMq.RabbitUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TtSpringbootDemoApplicationTests {

    @Autowired
    private RabbitSender rabbitSender;

//    @Test
//    public void contextLoads() {
//        rabbitSender.sendRabbitmqDirect(RabbitUtil.EXCHANGE_TWO,RabbitUtil.QUEUE_TWO,RabbitUtil.ROUTE_TWO,"Hello RabbitMq TWO");
//    }

    @Test
    public void contextLoads() {
        rabbitSender.sendRabbitmqFanout(RabbitUtil.EXCHANGE_FANOUT,"Hello RabbitMq FANOUT!");
    }

}
