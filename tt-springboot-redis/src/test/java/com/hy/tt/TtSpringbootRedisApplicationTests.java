package com.hy.tt;

import com.hy.tt.redis.RedisConfig;
import com.hy.tt.redis.RedisUtil;
import com.hy.tt.redis.TestObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TtSpringbootRedisApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

//    @Test
//    public void contextLoads() {
//
//        TestObject test = new TestObject();
//        test.setName("test");
//        test.setAge(1);
//        List<String> friends  = new ArrayList<>();
//        friends.add("tom");
//        friends.add("nice");
//        friends.add("andy");
//        test.setFriends(friends);
//
//        String key = "test";
//
//        redisUtil.addKey(key,test);
//        TestObject value = (TestObject)redisUtil.getValue(key);
//        System.out.println("get redis value:" + value.toString());
//    }



//    @Test
//    public void nearly(){
//        String key = "t";
//        redisUtil.geoAdd(key,116.40,39.90,"蜘蛛侠");
//        redisUtil.geoAdd(key,116.40,39.90,"蝙蝠侠");
//        redisUtil.geoAdd(key,116.38,39.90,"大侠");
//        redisUtil.geoAdd(key,116.30,39.95,"煎饼侠");
//
//
//        redisUtil.geoPos(key,"蜘蛛侠",20000);
//
//        redisUtil.geoPosWithDist(key,"蜘蛛侠",20000);
//    }


    @Test
    public void list(){
        String key = "tttt";

        redisUtil.set(key);


    }


}
