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
import java.util.List;
import java.util.Set;
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


    /**
     * list 添加list 取出最近的10个
     * 业务: 可以实现刷新关注列表等
     * @param key
     */
    public void list(String key){
        for (int i = 1; i < 15; i++) {
            this.redisTemplate.opsForList().leftPush(key,i);
        }
        List<Object> range = this.redisTemplate.opsForList().range(key, 0, 9);
        range.stream().forEach( r -> System.out.println(r));
    }


    /**
     * 转盘中奖,点赞取消点赞等
     * rem 取消
     *
     * @param key
     */
    public void set(String key){
        this.redisTemplate.opsForSet().add(key, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

        Set<Object> members = this.redisTemplate.opsForSet().members(key);
        members.stream().forEach( r -> System.out.println(r));

        System.out.println("----------------------------------------");
        List<Object> objects = this.redisTemplate.opsForSet().randomMembers(key, 3);
        objects.stream().forEach( r -> System.out.println(r));

        System.out.println("----------------------------------------");

        List<Object> pop = this.redisTemplate.opsForSet().pop(key, 3);
        pop.stream().forEach( r -> System.out.println(r));
        System.out.println("----------------------------------------");

        Set<Object> members1 = this.redisTemplate.opsForSet().members(key);
        members1.stream().forEach( r -> System.out.println(r));

    }

}
