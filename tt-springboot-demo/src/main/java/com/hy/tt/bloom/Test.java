package com.hy.tt.bloom;

import java.sql.Array;

/**
 * @auther thy
 * @date 2019/11/8
 */
public class Test {

    /**
     * 自定义实现
     * 1.声明一个int数组
     * 2.把预制的数据通过取余 放入数组中
     * 3.当来的数也取余 是否在数组中  如果在 就可能存在  如果不在 一定不存在
     * @param args
     */
    public static void main(String[] args) {
        Integer num = 6;
        int[] array = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Integer a = 100;
        Integer b = 200;
        Integer c = 300;

        int anum = a % num;
        int bnum = b % num;
        int cnum = c % num;

        array[anum] = 1;
        array[bnum] = 1;
        array[cnum] = 1;


        int m = 9;
        int n = 10;

        int mnum = m % num;
        int nnum = n % num;
        if (array[mnum] == 1) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

        if (array[nnum] == 1) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
    }
}
