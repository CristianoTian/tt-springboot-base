package com.hy.tt.service;

import com.hy.tt.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {

    /**
     * 根据id查询用户信息
     * @param id 主键
     * @return User
     */
    User getById(Long id);

    void insert(User user);

    List<User> getAll();
}
