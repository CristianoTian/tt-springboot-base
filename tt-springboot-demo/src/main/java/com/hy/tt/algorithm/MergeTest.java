package com.hy.tt.algorithm;


import java.util.Arrays;

/**
 * @auther thy
 * @date 2019/10/8
 * 归并排序
 *
 *
 *
 */
public class MergeTest {

    public static void main(String[] args) {
        int[] array = {5,8,6,3,9,2,1,7};
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end){
        if(start<end){
            int mid = (start + end)/2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end){

        int[] tempArray = new int[end-start+1];
        int p1 = start, p2 = mid+1, p = 0;

        while (p1 <= mid && p2 <= end){
            if(array[p1] <= array[p2]){
                tempArray[p++] = array[p1++];
            }else{
                tempArray[p++] = array[p2++];
            }
        }

        while(p1<=mid)
            tempArray[p++] = array[p1++];

        while(p2<=end)
            tempArray[p++] = array[p2++];

        for (int i = 0; i < tempArray.length; i++) {
            array[i+start] = tempArray[i];
        }
    }










}
