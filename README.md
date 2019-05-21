# tt-springboot-base

第一阶段

springBoot 集成demo开发

1)集成rabbitMQ开发(tt-springboot-rabbitMq)

    Ⅰ.Direct模式----直连模式(点对点,涉及到交换机/队列/routingKey)
    Ⅱ.Fanout模式----广播模式
    Ⅲ.Topic模式-----匹配转发模式(* 代表一个单词/ #代表零个或者多个可匹配单词. 当routingKey为 # 广播模式,当不包含 */# 为直连模式)
    
2)自定义starter开发(tt-spring-starter,tt-spring-starter-demo)

    Ⅰ.首先自定义starter.其次demo集成自定义starter
    Ⅱ.用途:比如现在通用的swagger可以封装成starter,并且可以设置参数,线上应用屏蔽
      
    Step one: 在starter中定义读取配置文件的Proerties(有几种方式,自行搜索springBoot读取配置文件查阅)
    Step two: 创建逻辑实现类
    Step three: 配置自动注入Config
    Step four: 自定义META-INF --- spring.factories
      
3)集成redis开发

    Ⅰ.注意,默认是使用LettuceConnectionConfiguration加载连接池,配置前缀spring.redis.
    Ⅱ.可以自定义连接池,开启事务,选择哨兵或者分布式模式等
    