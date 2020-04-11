package com.hy.tt.jvm;

/**
 * @auther thy
 * @date 2020/4/3
 */
public class VolatileExample {

    /**
     * 执行结果不是0   原子性 ++ -- 改成 AtomicInteger
     */
    public static volatile int count = 0; // 计数器
    public static final int size = 100000; // 循环测试次数

    public static void main(String[] args) {
        // ++ 方式
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= size; i++) {
                count++;
            }
        });
        thread.start();
        // -- 方式
        for (int i = 1; i <= size; i++) {
            count--;
        }
        // 等所有线程执行完成
        while (thread.isAlive()) {}
        System.out.println(count); // 打印结果
    }
}
