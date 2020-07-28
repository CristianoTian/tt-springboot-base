package com.hy.tt;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @auther thy
 * @date 2020/3/11
 */
public class test1test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        //任务执行计数器
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            int currCount = count.getAndIncrement();
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis() + "第" + currCount + "次" + "开始执行");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "第" + currCount + "次" + "执行结束");
        }, 1, 1, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);
//        scheduledFuture.cancel(false);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("任务是否被取消："+scheduledFuture.isCancelled());
        System.out.println("任务是否已完成："+scheduledFuture.isDone());
    }
}
