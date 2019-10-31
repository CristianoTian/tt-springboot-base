package com.hy.tt.mode.template;

/**
 * @auther thy
 * @date 2019/10/31
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("学生甲抄的试卷：");
        StudentA studentA = new StudentA();
        studentA.testQuestion1();
        studentA.testQuestion2();
        studentA.testQuestion3();

        System.out.println();

        System.out.println("学生乙抄的试卷：");
        StudentB studentB = new StudentB();
        studentB.testQuestion1();
        studentB.testQuestion2();
        studentB.testQuestion3();

    }
}
