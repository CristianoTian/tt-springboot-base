# tt-springboot-base

第一阶段

springBoot 集成demo开发

1)集成rabbitMQ开发

    Ⅰ.Direct模式----直连模式(点对点,涉及到交换机/队列/routingKey)
    Ⅱ.Fanout模式----广播模式
    Ⅲ.Topic模式-----匹配转发模式(* 代表一个单词/ #代表零个或者多个可匹配单词. 当routingKey为 # 广播模式,当不包含 */# 为直连模式)