package com.hy.tt.redis.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @auther thy
 * @date 2019/10/12
 */
public class RedisDistributedRedLockTest {

    static int n = 5;
    public static void secskill() {
        if(n == 0) {
            System.out.println("抢购完成");
            return;
        }

        System.out.println(--n);
    }
    public static void main(String[] args) {

        Config config = new Config();
        //支持单机，主从，哨兵，集群等模式
        //此为集群
        config.useClusterServers()
                .addNodeAddress("redis://192.168.130.128:7001", "redis://192.168.130.128:7002","redis://192.168.130.128:7003")
                .setPassword("123456").setScanInterval(5000);
        Runnable runnable = () -> {
            RedisDistributedRedLock redisDistributedRedLock = null;
            RedissonClient redissonClient = null;

            redissonClient = Redisson.create(config);
            redisDistributedRedLock = new RedisDistributedRedLock(redissonClient, "tt");
            redisDistributedRedLock.acquire();
            secskill();
            System.out.println(Thread.currentThread().getName() + "正在运行");

        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
