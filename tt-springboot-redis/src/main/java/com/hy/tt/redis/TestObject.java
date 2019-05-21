package com.hy.tt.redis;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @auther thy
 * @date 2019/5/21
 */
@Data
@ToString
public class TestObject {

    private String name;
    private Integer age;
    private List<String>  friends;


}
