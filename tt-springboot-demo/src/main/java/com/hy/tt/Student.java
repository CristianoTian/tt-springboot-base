package com.hy.tt;

/**
 * @author thy
 * @date 2020/4/26
 */
public class Student {

    private String name;
    private Integer sortNum;

    public Student(String name, Integer sortNum) {
        this.name = name;
        this.sortNum = sortNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
