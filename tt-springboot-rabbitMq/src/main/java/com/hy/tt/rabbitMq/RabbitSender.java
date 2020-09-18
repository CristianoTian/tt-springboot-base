package com.hy.tt.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

/**
 * @auther thy
 * @date 2019/5/13
 */
@Slf4j
@Component
public class RabbitSender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitAdmin rabbitAdmin;
    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    //构造方法注入
    //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this::confirm);
        rabbitTemplate.setReturnCallback(this::returnedMessage);
    }

    /**
     * 发送没有的交换机就会失败
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("confirm: " + correlationData.getId());
        if (b) {
            log.info("消息发送到交换机成功");
        } else {
            log.info("消息发送到交换机失败:" + s);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("returnedMessage回调方法>>>" + new String(message.getBody(), StandardCharsets.UTF_8) + ",replyCode:" + replyCode
                + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
    }


    /**
     * Direct模式
     */
    public void sendRabbitmqDirect(String exchange, String queue, String routeKey,Object obj) {

        Properties queueProperties = rabbitAdmin.getQueueProperties(queue);
        if(queueProperties == null){
            rabbitAdmin.declareExchange(new DirectExchange(exchange));
            rabbitAdmin.declareQueue(new Queue(queue));
            rabbitAdmin.declareBinding(new Binding(queue, Binding.DestinationType.QUEUE,exchange,routeKey,new HashMap<>()));
        }

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(exchange, routeKey , obj, correlationData);
    }

    /**
     * Direct模式
     */
    public void sendRabbitmqDirect(String exchange, String queue, Boolean queueDurable,String routeKey,Object obj) {

        Properties queueProperties = rabbitAdmin.getQueueProperties(queue);
        if(queueProperties == null){
            rabbitAdmin.declareExchange(new DirectExchange(exchange));
            rabbitAdmin.declareQueue(new Queue(queue,queueDurable));
            rabbitAdmin.declareBinding(new Binding(queue, Binding.DestinationType.QUEUE,exchange,routeKey,new HashMap<>()));
        }

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(exchange, routeKey , obj, correlationData);
    }

    /**
     * Fanout 模式
     */
    public void sendRabbitmqFanout(String exchange,Object obj) {

        if(null == rabbitAdmin.getQueueProperties(RabbitUtil.QUEUE_FANOUT_ONE) || null == rabbitAdmin.getQueueProperties(RabbitUtil.QUEUE_FANOUT_TWO)){
            FanoutExchange fanoutExchange = new FanoutExchange(exchange);
            Queue queue1 = new Queue(RabbitUtil.QUEUE_FANOUT_ONE);
            Queue queue2 = new Queue(RabbitUtil.QUEUE_FANOUT_TWO);
            rabbitAdmin.declareExchange(fanoutExchange);
            rabbitAdmin.declareQueue(queue1);
            rabbitAdmin.declareQueue(queue2);
            rabbitAdmin.declareBinding(BindingBuilder.bind(queue1).to(fanoutExchange));
            rabbitAdmin.declareBinding(BindingBuilder.bind(queue2).to(fanoutExchange));
        }


        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(exchange,"", obj, correlationData);
    }

    /**
     * Topic 模式
     */
    public void sendRabbitTopic(String exchange, String routingKey,Object obj){

        if(null == rabbitAdmin.getQueueProperties(RabbitUtil.QUEUE_TOPIC_ONE)
                || null == rabbitAdmin.getQueueProperties(RabbitUtil.QUEUE_TOPIC_TWO)
                || null == rabbitAdmin.getQueueProperties(RabbitUtil.QUEUE_TOPIC_THREE)
        ){
            TopicExchange topicExchange = new TopicExchange(exchange);
            Queue queue1 = new Queue(RabbitUtil.QUEUE_TOPIC_ONE);
            Queue queue2 = new Queue(RabbitUtil.QUEUE_TOPIC_TWO);
            Queue queue3 = new Queue(RabbitUtil.QUEUE_TOPIC_THREE);
            rabbitAdmin.declareExchange(topicExchange);
            rabbitAdmin.declareQueue(queue1);
            rabbitAdmin.declareQueue(queue2);
            rabbitAdmin.declareQueue(queue3);
            rabbitAdmin.declareBinding(BindingBuilder.bind(queue1).to(topicExchange).with(RabbitUtil.ROUKTING_KEY_TOPIC));
            rabbitAdmin.declareBinding(BindingBuilder.bind(queue2).to(topicExchange).with(RabbitUtil.ROUKTING_KEY_TOPIC));
            rabbitAdmin.declareBinding(BindingBuilder.bind(queue3).to(topicExchange).with(RabbitUtil.ROUKTING_KEY_TOPIC_ONE));
        }

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(exchange,routingKey, obj, correlationData);
    }


}
