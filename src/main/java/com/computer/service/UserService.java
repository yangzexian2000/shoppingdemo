package com.computer.service;

import com.computer.bean.User;

import java.util.List;

/**
 * user的service层
 * @author yangzexian
 * @date 2022/01/10
 */
public interface UserService {
    /**
     * 根据用户的手机查询到用户信息 根据这个用户信息的有无发送验证码
     * @param user 用户数据对象
     * @return
     */
    List<User> listUsers(User user);

    /**
     * 注册账号
     * @param user  用户数据对象
     * @return
     */
    Integer saveUser(User user);

    /**
     * 更新用户密码
     * @param user  用户数据对象
     * @return
     */
    Integer updetaUserPwd(User user);

    /**
     * 更新用户的邮箱或者手机号
     * @param user
     * @return
     */
    Integer updetaUserEmaliOrPhone(User user);

    /**
     * 更新用户的头像信息
     * @param user
     * @return
     */
    Integer updateUserPhoto(User user);

    /**
     * 根据用户id查找用户信息
     * @param user
     * @return
     */
    User getUserByUserId(User user);
}
