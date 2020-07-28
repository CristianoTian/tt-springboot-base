package com.hy.tt.algorithm;

/**
 * @author thy
 * @date 2020/7/28
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int left = (m+n+1)/2;
        int right = (m+n+2)/2;

        return (digui(nums1,0,m-1,nums2,0,n-1,left)+digui(nums1,0,m-1,nums2,0,n-1,right))/2.0;

    }

    public static double digui(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1 > len2) {
            return digui(nums2,start2,end2,nums1,start1,end1,k);
        }
        if(len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int i = start1 + Math.min(len1,k/2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return digui(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return digui(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }
}
