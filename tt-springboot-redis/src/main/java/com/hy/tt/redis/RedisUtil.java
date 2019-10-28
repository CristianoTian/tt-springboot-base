package com.hy.tt.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;
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


    /**
     * 新增携带经纬度的数据
     * @param key
     * @param longitude
     * @param latitude
     * @param name
     */
    public void geoAdd(String key, double longitude, double latitude, String name){
        Point point = new Point(longitude,latitude);
        this.redisTemplate.opsForGeo().add(key,point,name);
    }

    /**
     * 查询附近的人
     * @param key
     * @param name
     * @param radius
     */
    public void geoPos(String key,String name,double radius){
        GeoResults<RedisGeoCommands.GeoLocation<Object>> radius1 = this.redisTemplate.opsForGeo().radius(key, name, radius);
        Iterator<GeoResult<RedisGeoCommands.GeoLocation<Object>>> iterator = radius1.iterator();
        while (iterator.hasNext()){
            GeoResult<RedisGeoCommands.GeoLocation<Object>> next = iterator.next();
            Object name1 = next.getContent().getName();
            System.out.println(name1);
        }
    }


    /**
     * 查询附近的人 ---  携带两者的距离 排序
     * @param key
     * @param name
     * @param radius
     */
    public void geoPosWithDist(String key,String name,double radius){
        RedisGeoCommands.GeoRadiusCommandArgs radiusCommandArgs = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
        radiusCommandArgs.includeDistance().sortAscending().limit(20);
        Distance distance = new Distance(radius);
        GeoResults<RedisGeoCommands.GeoLocation<Object>> radius1 = this.redisTemplate.opsForGeo().radius(key, name, distance,radiusCommandArgs);
        Iterator<GeoResult<RedisGeoCommands.GeoLocation<Object>>> iterator = radius1.iterator();
        while (iterator.hasNext()){
            GeoResult<RedisGeoCommands.GeoLocation<Object>> next = iterator.next();
            Object name1 = next.getContent().getName();
            double value = next.getDistance().getValue();
            System.out.println(name1  + "|" + value);
        }
    }

}
