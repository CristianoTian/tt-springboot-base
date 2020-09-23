package com.hy.tt.service.impl;

import com.hy.tt.entity.User;
import com.hy.tt.mapper.UserMapper;
import com.hy.tt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thy
 * @date 2020/9/22
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
