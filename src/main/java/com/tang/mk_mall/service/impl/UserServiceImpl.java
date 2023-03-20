package com.tang.mk_mall.service.impl;

import com.tang.mk_mall.model.dao.UserMapper;
import com.tang.mk_mall.model.pojo.User;
import com.tang.mk_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService 实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(2);
    }

}
