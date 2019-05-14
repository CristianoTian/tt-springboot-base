package com.hy.tt.rabbitMq;

/**
 * @auther thy
 * @date 2019/5/13
 */
public class RabbitUtil {

    /**
     * direct
     */
    //交换机名称
    public static final String EXCHANGE_TWO = "EXCHANGETWOS";
    //队列名称
    public static final String QUEUE_TWO = "QUEUETWOS";
    //routeKey
    public static final String ROUTE_TWO = "ROUTETWOS";


    /**
     * fanout
     */
    //交换机名称
    public static final String EXCHANGE_FANOUT = "EXCHANGE.FANOUT";
    //队列名称
    public static final String QUEUE_FANOUT_ONE = "QUEUE.FANOUT.ONE";
    public static final String QUEUE_FANOUT_TWO = "QUEUE.FANOUT.TWO";


    /**
     * topic
     */
    //交换机名称
    public static final String EXCHANGE_TOPIC = "EXCHANGE.TOPIC";
    //队列名称
    public static final String QUEUE_TOPIC_ONE = "QUEUE.TOPIC.ONE";
    public static final String QUEUE_TOPIC_TWO = "QUEUE.TOPIC.TWO";
    public static final String QUEUE_TOPIC_THREE = "QUEUE.TOPIC.THREE";
    //routingKey
    public static final String ROUKTING_KEY_TOPIC = "topic.#";
    public static final String ROUKTING_KEY_TOPIC_ONE = "topic.*";
}
