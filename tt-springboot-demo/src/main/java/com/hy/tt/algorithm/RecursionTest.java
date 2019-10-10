package com.hy.tt.algorithm;

/**
 * @auther thy
 * @date 2019/10/9
 */
public class RecursionTest {

    public static void main(String[] args) {
        remove(4,'a','b','c');
    }

    private static  void remove(int n,char a, char b, char c){
        if(n==1){
            System.out.println( a  + " ---> " + c);
            return ;
        }

        remove(n - 1, a, c, b);
        remove(1, a, b, c);
        remove(n - 1, b, a, c);
    }
}
