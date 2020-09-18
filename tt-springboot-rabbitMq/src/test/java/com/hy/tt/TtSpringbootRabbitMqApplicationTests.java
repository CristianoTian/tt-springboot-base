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
public class TtSpringbootRabbitMqApplicationTests {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void contextLoads() {
        rabbitSender.sendRabbitmqDirect(RabbitUtil.EXCHANGE_TWO,RabbitUtil.QUEUE_TWO,RabbitUtil.ROUTE_TWO,"Hello RabbitMq TWO11");
//        rabbitSender.sendRabbitmqDirect(RabbitUtil.TEMP_EXCHANGE_TWO,RabbitUtil.TEMP_QUEUE_TWO,false,RabbitUtil.TEMP_ROUTE_TWO,"Hello RabbitMq durable false");
    }

//    @Test
//    public void contextLoads() {
//        rabbitSender.sendRabbitmqFanout(RabbitUtil.EXCHANGE_FANOUT,"Hello RabbitMq FANOUT!");
//    }


//    /**
//     * routingkey  topic.aaa  3个Listener 都执行
//     *              topic.aaa.nn   只有配置.#的执行
//     */
//    @Test
//    public void contextLoads() {
//
//        rabbitSender.sendRabbitTopic(RabbitUtil.EXCHANGE_TOPIC,"topic.aa.bb","Hello RabbitMq FANOUT!");
//    }
}
