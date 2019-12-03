package com.hy.tt.seckill;

import org.springframework.http.HttpRequest;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @auther thy
 * @date 2019/11/29
 */
public class RequestQueue {

    public static ConcurrentLinkedQueue<HttpRequest> queue = new ConcurrentLinkedQueue<HttpRequest>();
}
