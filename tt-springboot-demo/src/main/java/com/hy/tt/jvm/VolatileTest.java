package com.hy.tt.jvm;

/**
 * @auther thy
 * @date 2020/4/3
 */
public class VolatileTest {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("新线程已经设置flag = " + flag);
        }).start();

        while(true){
            if(flag){
                System.out.println("主线程获取flag = " + flag);
                break;
            }
            /**
             * why do the last row to can break???
             */
//            System.out.println("主线程获取flag = " + flag);
        }
    }
}
