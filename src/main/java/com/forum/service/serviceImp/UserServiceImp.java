package com.forum.service.serviceImp;

import com.forum.dao.UserDao;
import com.forum.entity.User;
import com.forum.service.UserService;
import com.forum.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by haitang on 2017/6/5.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public int Register(String username,String email,String password) {
        User user1=userDao.findUserByEmail(email);
        //该邮箱已被注册
        if(user1!=null){
            return -1;
        }
        //该昵称已被使用
        user1=userDao.findUserByName(username);
        if(user1!=null){
            return -2;
        }
        //默认的用户头像
        String heading="/resources/image/default.jpg";
        User user=new User(0,username, StringUtils.MD5(password),email,heading);
        return userDao.addUser(user);
    }

    @Override
    public int checkLogin(String username, String password) {
       User user=userDao.findUserByName(username);
       //如果该昵称不存在
       if(user==null){
           return -1;
       }
       //如果输入的密码错误
       if(!user.getPassword().equals(StringUtils.MD5(password))){
           return -2;
       }
        return 1;
    }

    @Transactional
    @Override
    public int updateUserInfo(Integer userId, String username, String password) {
        User user=userDao.findUserByName(username);
        //该昵称已被使用
        if(user!=null&&!user.getUserId().equals(userId)){
            return -1;
        }
        return userDao.updateUserInfo(userId,username, StringUtils.MD5(password));
    }

    @Override
    public int updateUserHeading(Integer userId, String heading) {
        return 0;
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}
