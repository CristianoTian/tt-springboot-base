package com.hy.tt.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @auther thy
 * @date 2019/5/21
 */
@Component
public class RedisUtil {

    private static final long EXPIRE_SECONDS = 60;//一分钟

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     *
     * @param key
     * @param value
     */
    public void addKey(String key, Object value){
        this.addKey(key,value,EXPIRE_SECONDS,TimeUnit.SECONDS);
    }
    /**
     * 添加字符串KEY
     *
     * @param key      字符串KEY
     * @param value    值 可以为对象
     * @param expire   过期时间
     * @param timeUnit TimeUnit中定义的时间单位
     */
    public void addKey(String key, Object value, long expire, TimeUnit timeUnit) {
        this.redisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }


    /**
     * 根据KEY获取VALUE
     *
     * @param key
     * @return value
     */
    public Object getValue(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

}
