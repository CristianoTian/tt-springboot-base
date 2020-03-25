package com.hy.tt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

/**
 * @auther thy
 * @date 2020/3/11
 */
public class test1test {
    public static void main(String[] args) {
        String a = "{\"status\":\"1020\"}";
        JSONObject jsonObject = JSON.parseObject(a);
        System.out.println(jsonObject);
    }
}
