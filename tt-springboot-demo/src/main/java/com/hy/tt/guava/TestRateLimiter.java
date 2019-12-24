package com.hy.tt.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @auther thy
 * @date 2019/12/23
 */
public class TestRateLimiter {

    public static void main(String[] args) {
        brokenRateLimiter();
    }

    private static void waitRateLimiter(){
        //1秒产生1个令牌
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10 ; i++) {
            //该方法会阻塞线程，直到令牌桶中能取到令牌为止才继续向下执行。
            double waitTime = rateLimiter.acquire();
            System.out.println("任务执行" + i + "等待时间" + waitTime);
        }
        System.out.println("执行结束");
    }

    private static void brokenRateLimiter(){
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            //让每个任务尝试在0.5秒获取令牌
            Long timeout = (long)0.5;
            boolean b = rateLimiter.tryAcquire(timeout, TimeUnit.SECONDS);
            System.out.println("任务" + i + "执行是否有效:" + b);
            if(!b){
                continue;
            }
            System.out.println("任务" + i + "在执行");
        }
        System.out.println("结束");
    }
}
