package com.computer.service.impl;

import com.computer.bean.User;
import com.computer.dao.UserDao;
import com.computer.service.UserService;
import com.computer.utils.MD5utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user的实现层
 * @author yangzexian
 * @date 2022/01/10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> listUsers(User user) {
        return userDao.listUsers(user);
    }

    @Override
    public Integer saveUser(User user) {
        //进行加密
        user.setUserPwd(MD5utils.getMD5Code(user.getUserPwd()));
        return userDao.saveUser(user);
    }

    @Override
    public Integer updetaUserPwd(User user) {
        user.setUserPwd(MD5utils.getMD5Code(user.getUserPwd()));
        return userDao.updetaUserPwd(user);
    }

    @Override
    public Integer updetaUserEmaliOrPhone(User user) {
        return userDao.updetaUserEmaliOrPhone(user);
    }

    @Override
    public Integer updateUserPhoto(User user) {
        return userDao.updateUserPhoto(user);
    }

    @Override
    public User getUserByUserId(User user) {
        return userDao.getUserByUserId(user);
    }


}
