package com.hy.tt.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @auther thy
 * @date 2019/11/20
 */
public class PropertiesTest {

    public static void main(String[] args) throws IllegalAccessException {
        Student student1 = new Student("张无忌",20);
        Student student2 = new Student("周芷若",18);
        Student student3 = new Student("赵敏",19);
        Student student4 = new Student("阿朱",20);
        Student student5 = new Student("小昭",17);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        student1.setFriends(students);


        Field[] declaredFields = student1.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            System.out.println("class filed:" + field );
            field.setAccessible(true);
            Object o = field.get(student1);
            System.out.println(o.toString());
        }
    }
}
