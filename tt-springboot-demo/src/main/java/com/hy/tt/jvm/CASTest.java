package com.hy.tt.jvm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author thy
 * @date 2020/7/28
 */
public class CASTest {
    volatile  static int count = 0;

    public static  int getCount() {
        return count;
    }

    public static void request() throws InterruptedException {
        //模拟耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
        int expectCount;
        do {
            expectCount = getCount();
        }while (!compareAndSwap(expectCount,expectCount+1));
    }

    public static synchronized boolean compareAndSwap(int expectCount,int newCount){
        if(getCount() == expectCount){
            count = newCount;
            return true;
        }
        return false;
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
