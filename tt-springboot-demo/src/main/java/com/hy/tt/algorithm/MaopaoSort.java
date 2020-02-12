package com.hy.tt.algorithm;

import java.util.Arrays;

/**
 * @auther thy
 * @date 2020/2/12
 */
public class MaopaoSort {

    public static void main(String[] args) {
        int[] array = {5,8,6,3,9,2,1,7};
        maopaoSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void maopaoSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    flag = true;
                }
            }
            System.out.println("第"+(i+1)+"轮排序后的数组为: "+Arrays.toString(array));
            if(flag == false)
            {
                System.out.println("本轮中的两两比较未发生元素互换，排序已经完成啦");
                return;
            }
        }
    }
}
