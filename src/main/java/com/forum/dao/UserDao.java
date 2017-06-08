package com.forum.dao;

import com.forum.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by haitang on 2017/6/4.
 * 处理用户的dao
 */
public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    int addUser(@Param("user") User user);

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return
     */
    User findUserById(@Param("userId") Integer userId);

    /**
     * 根据用户的昵称查找用户
     * @param username
     * @return
     */
    User findUserByName(@Param("username") String username);

    /**
     * 根据邮箱查找用户
     * @param email
     * @return
     */
    User findUserByEmail(@Param("email") String email);

    /**
     *
     * @param userId
     * @param username
     * @param password
     * @return
     */
    int updateUserInfo(@Param("userId") Integer userId,@Param("username") String username,@Param("password") String password);
}
