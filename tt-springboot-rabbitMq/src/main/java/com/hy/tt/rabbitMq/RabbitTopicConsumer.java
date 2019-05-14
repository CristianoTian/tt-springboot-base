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
public class RabbitTopicConsumer {

    @RabbitListener(queues = RabbitUtil.QUEUE_TOPIC_ONE)
    public void topicOne(String content){
        log.info("topic one 接收处理数据为:"+ content);
    }

    @RabbitListener(queues = RabbitUtil.QUEUE_TOPIC_TWO)
    public void topicTwo(String content){
        log.info("topic two 接收处理数据为:"+ content);
    }

    @RabbitListener(queues = RabbitUtil.QUEUE_TOPIC_THREE)
    public void topicThree(String content){
        log.info("topic 3 接收处理数据为:"+ content);
    }
}
