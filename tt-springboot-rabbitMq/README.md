# rabbitmq

1.保证消息不丢失
   * 不启用rabbitmq，发送者直接发送消息 （分别打开关闭ack）
   * rabbitmq queue持久化 和 数据持久化 
   * 消费者不开启ack，开启自动ack，业务处理完手动ack
   
2.保证消息顺序消费
   * 确保一个queue 被 一个消费者消费

3.保证不重复消费
   * 幂等消费
   
 