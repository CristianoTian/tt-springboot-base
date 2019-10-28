package com.hy.tt.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther thy
 * @date 2019/10/24
 */
public class Test {
    public static void main(String[] args) {
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set("hello");
//        System.out.println(Thread.currentThread().getName() + threadLocal.get());
//        threadLocal.set("hello1");
//        System.out.println(Thread.currentThread().getName() + threadLocal.get());
//        ThreadLocal threadLocal1 = new ThreadLocal();
//        threadLocal1.set("hello11");
//        System.out.println(Thread.currentThread().getName() + threadLocal1.get());
//        //启动另一个线程
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName() +  threadLocal.get());
//        }).start();

        AtomicInteger nextHashCode =
                new AtomicInteger();

        System.out.println(nextHashCode);
        System.out.println(nextHashCode.getAndAdd(0x61c88647));
        System.out.println(nextHashCode.getAndAdd(0x61c88647));
        System.out.println(nextHashCode.getAndAdd(0x61c88647));
    }
}
