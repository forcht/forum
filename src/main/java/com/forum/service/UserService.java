package com.forum.service;

import com.forum.entity.User;

/**
 * Created by haitang on 2017/6/4.
 */

public interface UserService {

    /**
     * 用户注册
     * @param username
     * @param email
     * @param password
     * @return
     */
    int Register(String username,String email,String password);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    int checkLogin(String username,String password);


    /**
     * 根据用户ID修改用户信息
     * @param userId
     * @param username
     * @param password
     * @return
     */
     int updateUserInfo(Integer userId,String username,String password);

    /**
     * 根据用户ID修改用户头像
     * @param userId
     * @param heading
     * @return
     */
    int updateUserHeading(Integer userId,String heading);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findUserByName(String username);
}
