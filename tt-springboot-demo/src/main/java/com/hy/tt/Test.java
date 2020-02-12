package com.hy.tt;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther thy
 * @date 2020/1/17
 */
public class Test {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String a = "123213";
        s.add(a);
        s.add("dgfdsfsf");
        s.add("SFDSFsdfdsf");
        s.add(a);
//        System.out.println(s.toString());
//        set.add(a);
//        set.add("dgfdsfsf");
//        set.add("SFDSFsdfdsf");
//        set.add(a);
//        System.out.println(set.toString());

        System.out.println(s.stream().distinct());

    }
}
