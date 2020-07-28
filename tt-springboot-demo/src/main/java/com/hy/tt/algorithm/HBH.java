package com.hy.tt.algorithm;

/**
 * @author thy
 * @date 2020/7/27
 */
public class HBH {

    public static void main(String[] args) {
        getResultByFor3();
        System.out.println("----------------------------");
        getResultByFor2();
    }

    public static void getResultByFor3(){
        int x,y,z;
        for (x = 0; x < 20; x++) {
            for (y = 0;  y< 33; y++) {
                for(z = 0; z<300; z = z +3){
                    if((5*x+3*y+z/3==100)&&(x+y+z==100)){
                        System.out.println("公鸡数："+x+" 母鸡数:"+y+" 小鸡数:"+z);
                    }
                }
            }
        }
    }

    public static void getResultByFor2(){
       int m = 100;
       int n = 100;
       int k;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                k = n - i - j ;
                if(k>0 && k%3==0 && (5*i + 3*j + k/3) == m){
                    System.out.println("公鸡数："+i+" 母鸡数:"+j+" 小鸡数:"+k);
                }
            }
        }
    }
}
