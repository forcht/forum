package com.forum.dao;

import com.forum.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by haitang on 2017/6/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testaddUser(){
        User user=new User(Integer.parseInt("11"),"csscd","cc","cc","cc");
        userDao.addUser(user);
    }
    @Test
    public void testFindUserById(){
        User user=userDao.findUserById(5);
        System.out.println(user);
    }
    @Test
    public void testFindUserByName(){
        User user=userDao.findUserByName("cc");
        System.out.println(user);
    }
    @Test
    public void testUpdateUserInfo(){
        User user=new User(Integer.parseInt("1"),"aaa","cca","cc","cc");
        System.out.println(userDao.updateUserInfo(user.getUserId(),user.getUsername(),user.getPassword()));
    }
}
