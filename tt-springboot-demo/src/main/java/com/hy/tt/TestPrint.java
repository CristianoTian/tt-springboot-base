package com.hy.tt;

import com.google.common.collect.Maps;

/**
 * @author thy
 * @date 2020/8/4
 */
public class TestPrint {
    public static void main(String[] args) {
        char[] ch=new char[]{'x','y'};
        System.out.println(ch);

        char[] ch1=new char[]{'x','y'};
        System.out.println("ch1="+ch1);

        Student s = new Student("tt","30");
        System.out.println("111"+s);

        Maps.EntryTransformer<String, String, Student> aNew = Student::new;
    }

     static class Student {
        String name;
        String age;



         public Student(String name, String age) {
             this.name = name;
             this.age = age;
         }

         @Override
         public String toString() {
             return "Student{" +
                     "name='" + name + '\'' +
                     ", age='" + age + '\'' +
                     '}';
         }
     }
}
