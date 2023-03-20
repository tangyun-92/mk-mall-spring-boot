package com.tang.mk_mall.service;

import com.tang.mk_mall.exception.MallException;
import com.tang.mk_mall.model.pojo.User;

/**
 * UserService
 */
public interface UserService {

    User getUser();

    void register(String userName, String password) throws MallException;

    User login(String userName, String password) throws MallException;

    void updateInformation(User user) throws MallException;
}
