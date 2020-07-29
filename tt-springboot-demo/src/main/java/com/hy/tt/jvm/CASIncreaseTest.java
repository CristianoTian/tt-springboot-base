package com.hy.tt.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author thy
 * @date 2020/7/29
 */
public class CASIncreaseTest {

    static Unsafe unsafe;
    //用来记录网站访问量，每次访问+1
    static int count;
    //count在Demo.class对象中的地址偏移量
    static long countOffset;

    static{
        try{
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            Field countField = CASIncreaseTest.class.getDeclaredField("count");
            countOffset = unsafe.staticFieldOffset(countField);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //模拟访问一次
    public static void request() throws InterruptedException {
        //模拟耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
        //对count原子加1
        unsafe.getAndAddInt(CASIncreaseTest.class, countOffset, 1);
    }

    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "，耗时：" + (endTime - starTime) + ",count=" + count);
    }
}
