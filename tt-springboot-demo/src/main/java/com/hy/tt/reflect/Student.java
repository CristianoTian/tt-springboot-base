package com.hy.tt.reflect;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @auther thy
 * @date 2019/11/20
 */
@Setter
@Getter
@ToString
public class Student implements Serializable {
    private static final long serialVersionUID = 6103912719111164820L;

    private String name;
    private int age;
    private List<Student> friends;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
