package com.hy.tt.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/5/14
 */
@Slf4j
@Component
public class RabbitFanoutConsumer {

    @RabbitListener(queues = RabbitUtil.QUEUE_FANOUT_ONE)
    public void consumerOne(String content){
        log.info("FANOUT ONE 接收处理数据为:"+ content);
    }

    @RabbitListener(queues = RabbitUtil.QUEUE_FANOUT_TWO)
    public void consumerTwo(String content){
        log.info("FANOUT TWO 接收处理数据为:"+ content);
    }
}
