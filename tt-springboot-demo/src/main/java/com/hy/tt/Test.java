package com.hy.tt;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther thy
 * @date 2020/1/17
 */
public class Test {

    public static void main(String[] args) {
        List<Student> s = new ArrayList<>();
        Student s1 = new Student("tt4",4);
        Student s2 = new Student("tt2",2);
        Student s3 = new Student("tt3",3);
        Student s4 = new Student("tt1",1);
        s.add(s1); s.add(s2);s.add(s3);s.add(s4);

        List<Student> sortList1 = s.stream()
                .sorted((a, b) -> a.getSortNum().compareTo(b.getSortNum()))
                .collect(Collectors.toList());

        for(Student ss : sortList1){
            System.out.println("name:" + ss.getName() + "sortNum:" + ss.getSortNum());
        }

        System.out.println(System.getProperty("os.name").toLowerCase());


    }
}
