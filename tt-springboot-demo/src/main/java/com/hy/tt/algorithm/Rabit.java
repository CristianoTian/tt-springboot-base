package com.hy.tt.algorithm;

/**
 * @author thy
 * @date 2020/7/27
 */
public class Rabit {

    public static void main(String[] args) {
        int rabitFormMoon = getRabitFormMoon(13);
        System.out.println(rabitFormMoon);
    }

    /**
     * 兔子问题。 定一对大兔子每月能生一对小兔子，
     * 且每对新生的小兔子经过一个月可以长成一对大兔子,具备繁殖能力，
     * 如果不发生死亡，且每次均生下一雌一雄，问一年后共有多少对兔子？
     */
    public static int getRabitFormMoon(int n){
        if(n<0){
            System.out.println("输入的月数不能小于0");
            return 0;
        }
        if(n==1||n==2){   //第一项和第二项都等于1，所以当是n=1和n=2都返回1
            return 1;
        }
        return getRabitFormMoon(n-1)+getRabitFormMoon(n-2);   //如果不是第一和第二项，则返回前一项+前一项的前一项的和
    }
}
