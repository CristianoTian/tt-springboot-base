package com.hy.tt.mapper;

import com.hy.tt.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id 主键
     * @return User
     */
    User getById(@Param("id") Long id);

    void insert(@Param("user")User user);

    List<User> getAll();
}
