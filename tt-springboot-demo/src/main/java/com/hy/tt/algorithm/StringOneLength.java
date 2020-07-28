package com.hy.tt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author thy
 * @date 2020/7/27
 */
public class StringOneLength {

    /**
     * [3, 2, 1, 0, 1, 2, 3, 4, 4, 3, 2, 1, 0, 1, 1, 0, 1, 2, 3, 4]
     */
    public static void main(String[] args) {
        String s = "lovechinalovebiejing";
        char a = 'e';
        test(s, a);
    }

    public static void test(String s,char a){
        int[] i = new int[s.length()];
        ArrayList<Integer> list = new ArrayList<Integer>(16);
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j) == a){
                list.add(j);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            int min = s.length();
            if(s.charAt(j) == a){
                i[j] = 0;
            }else{
                for(Integer index : list){
                    int abs = Math.abs(j - index);
                    if(abs<min){
                        min = abs;
                    }
                }
                i[j] = min;
            }
        }
        System.out.println(Arrays.toString(i));
    }
}
