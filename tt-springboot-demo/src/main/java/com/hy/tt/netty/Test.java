package com.hy.tt.netty;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @auther thy
 * @date 2020/3/18
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        final Semaphore semaphore = new Semaphore(0);
//        final AtomicReference<Thread> thread = new AtomicReference<Thread>();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        workerGroup.next().execute(new Runnable() {
//            @Override public void run() {
//                thread.set(Thread.currentThread());
//                semaphore.release();
//            }
//        });
//        semaphore.acquire();
//        thread.get().interrupt();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("222222");
            }
        });
    }
}
