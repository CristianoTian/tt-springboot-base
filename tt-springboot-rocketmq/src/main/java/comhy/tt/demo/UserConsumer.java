package comhy.tt.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @auther thy
 * @date 2019/11/18
 */
@Component
public class UserConsumer {

    /**
     * 消费者的组名
     */
    @Value("${tt.rocketmq.conumerGroup}")
    private String consumerGroup;

    /**
     * NameServer 地址
     */
    @Value("${tt.rocketmq.namesrvaddr}")
    private String namesrvAddr;


    @PostConstruct
    public void consumer(){
        System.err.println("init consumer");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        try{
            consumer.subscribe("user-topic","user-tag");
            consumer.registerMessageListener((MessageListenerConcurrently)(list,context) ->{

                try{
                    for(MessageExt messageExt : list){
                        System.err.println("消息消费: " + new String(messageExt.getBody()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
