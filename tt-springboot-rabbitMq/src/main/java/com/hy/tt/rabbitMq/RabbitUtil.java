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


}
