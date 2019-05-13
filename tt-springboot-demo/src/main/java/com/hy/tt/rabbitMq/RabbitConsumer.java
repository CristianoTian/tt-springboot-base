package com.hy.tt.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/5/13
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitUtil.QUEUE_TWO)//由于TWO 是通过生产者自动生成的 ,所以第一次启动注释掉消费者 ,或者手动创建
public class RabbitConsumer {

    @RabbitHandler
    public void message(String content){
        log.info("接收处理数据为:"+ content);
    }

}
