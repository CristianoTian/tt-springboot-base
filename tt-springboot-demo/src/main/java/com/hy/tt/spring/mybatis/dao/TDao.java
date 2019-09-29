package com.hy.tt.spring.mybatis.dao;

import com.hy.tt.spring.mybatis.entity.TEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther thy
 * @date 2019/9/29
 */
//开启二级缓存
//@CacheNamespace
@Repository
public interface TDao {

    @Select("select * from id_generate")
    List<TEntity> query();
}
