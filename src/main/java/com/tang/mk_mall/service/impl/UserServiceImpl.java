package com.tang.mk_mall.service.impl;

import com.tang.mk_mall.exception.MallException;
import com.tang.mk_mall.exception.MallExceptionEnum;
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

    @Override
    public void register(String userName, String password) throws MallException {
        // 查询用户名是否存在，不允许重名
        User result = userMapper.selectByName(userName);
        if (result != null) {
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }

        // 写到数据库
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        int count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

}
