package com.hy.tt.redis.lock;

import org.redisson.RedissonMultiLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @auther thy
 * @date 2019/10/12
 */
public class RedisDistributedRedLock implements DistributedLock {


     //reids客户端
    private RedissonClient redissonClient;
    private String key;

    //有效锁锁的过期时间
    int expireTime = 10 * 1000;

    //获取锁的超时时间
    int acquireTimeout = 500;

    public RedisDistributedRedLock(RedissonClient redissonClient, String key) {
        this.redissonClient = redissonClient;
        this.key = key;
    }

    @Override
    public String acquire() {
        RLock lock = redissonClient.getLock("{str1}" + key);
        RLock lock1 = redissonClient.getLock("{str2}" + key);
        RLock lock2 = redissonClient.getLock("{str3}" + key);
        RLock lock3 = redissonClient.getLock("{str4}" + key);
        RLock lock4 = redissonClient.getLock("{str5}" + key);
        RLock lock5 = redissonClient.getLock("{str6}" + key);

        RedissonMultiLock redissonMultiLock = new RedissonMultiLock(lock, lock1, lock2, lock3, lock4, lock5);

        boolean isLock;
        try{
            isLock= redissonMultiLock.tryLock(acquireTimeout, expireTime, TimeUnit.MILLISECONDS);
            if(isLock){
                System.out.println(Thread.currentThread().getName() + " " + key + "获取了锁!");
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redissonMultiLock.unlock();
        }
        return null;
    }



}
