package com.hy.tt.jdk8Optional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @auther thy
 * @date 2019/12/17
 */
public class Test {
    public static void main(String[] args) {
        Optional.ofNullable(getById(1)).ifPresent(student -> {
            System.out.println(student.getName());
            System.out.println(student.getId());
            System.out.println(1);
        });
//        System.out.println(optionalStudent);
    }

    public static Student getById(@NotNull  Integer id){
        Student s = new Student();
//        s.setId(1);
//        s.setName("test");
        return  null;
    }
}
