package com.hy.tt.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther thy
 * @date 2019/11/19
 */
public class CasTest {


    private static int data = 0;

    private static AtomicInteger dataInt = new AtomicInteger(0);
    /**
     * 1.synchronized
     * 2.修改int类型 AtomicInteger
     *      利用cas 对比修改 ,但是存在自循环消耗cpu
     *
     * 3. 使用LongAdder\
     *      利用分段cas 以及 自动分段迁移
     */
    public  static void increment(){
        dataInt.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(1000);
        System.out.println(dataInt);
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100000000; i++) {
                increment();
            }
        }
    }
}
