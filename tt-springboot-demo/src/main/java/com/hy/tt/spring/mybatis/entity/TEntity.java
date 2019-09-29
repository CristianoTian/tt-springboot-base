package com.hy.tt.spring.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther thy
 * @date 2019/9/29
 */
@Data
public class TEntity implements Serializable {

    private Integer table_name;

    private Integer generate_id;

    private long version_code;
}
