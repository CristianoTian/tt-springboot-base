package com.hy.tt.rabbitMq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @auther thy
 * @date 2019/5/13
 */
@Slf4j
@Component
public class RabbitDirectConsumer {

    @RabbitListener(queues = RabbitUtil.QUEUE_TWO)//由于TWO 是通过生产者自动生成的 ,所以第一次启动注释掉消费者 ,或者手动创建
    public void message(Message content, Channel channel) throws IOException {
        long deliveryTag = content.getMessageProperties().getDeliveryTag();
        log.info("接收处理数据为:"+ new String(content.getBody(),"UTF-8"));
//        channel.basicNack(deliveryTag,false,true);//处理失败设置
        channel.basicAck(deliveryTag,false);//手动设置回应
    }

}
