package com.forum.service;

import com.forum.dao.UserDao;
import com.forum.entity.User;
import com.forum.utils.EmailUtils;
import com.forum.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Created by haitang on 2017/6/5.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     * @param username
     * @param email
     * @param password
     * @return
     */
    @Transactional
    public Map<String,String> Register(String username,String email,String password) {
        User user=userDao.findUserByEmail(email);
        Map<String,String> map=new HashMap<>();
        //该邮箱已被注册
        if(user!=null){
            map.put("data","该邮箱已注册");
            return map;
        }
        //该用户名已被使用
        user=userDao.findUserByName(username);
        if(user!=null){
            map.put("data","该用户名已被使用");
            return map;
        }
        //默认的用户头像
        String heading="/resources/imgs/default.jpg";
        //用户激活码
        String code= UUID.randomUUID().toString();
        user=new User(username, StringUtils.MD5(password),email,heading,code);
        int flag=userDao.addUser(user);
        if (flag==0){
            map.put("data","注册失败");
            return map;
        }
        //发送验证邮件
        EmailUtils.sendEmail(email,code);
        map.put("data","注册成功，请登录您的邮箱激活账户");
        return map;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    public Map<String,String> Login(String username, String password, HttpSession session) {
       User user=userDao.findUserByName(username);
       Map<String,String> map=new HashMap<>();
       //如果该昵称不存在
       if(user==null){
           map.put("data","用户不存在");
           return map;
       }
       //如果输入的密码错误
       if(!user.getPassword().equals(StringUtils.MD5(password))){
           map.put("data","输入密码错误");
           return map;
       }
       session.setAttribute("user",userDao.findUserByName(username));
       map.put("data","登录成功");
        return map;
    }

    @Transactional
    public ModelAndView updateUserHeadingAndUsername(HttpServletRequest request, MultipartFile file, String username) {
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        ModelAndView modelAndView=new ModelAndView();
        //用户名被修改了
        if(!username.equals(user.getUsername())){
            //该用户名被注册了
            if (userDao.findUserByName(username)!=null){
                modelAndView.addObject("data","该用户名已被注册");
                return modelAndView;
            }
            //修改用户名
            userDao.updateUserUsername(user.getUserId(),username);
            user.setUsername(username);
        }
        //用户的头像没有修改
        if(file.isEmpty()){
            session.setAttribute("user",user);
            return modelAndView;
        }
        //修改数据库中用户的头像
        String heading=uploadFile(file,request);
        user.setHeading(heading);
        userDao.updateUserHeading(user.getUserId(),heading);
        session.setAttribute("user",user);
        return modelAndView;
    }

    public ModelAndView activateUser(String code) {
        User user=userDao.findUserByCode(code);
        ModelAndView modelAndView=new ModelAndView();
        //激活成功
        if(user!=null){
            //激活用户，消除激活码，激活码只能使用一次
            user.setCode("");
            user.setState(1);
            userDao.updateUserCodeAndState(user.getUserId(),user.getCode(),user.getState());
            modelAndView.addObject("user",user);
            modelAndView.addObject("data","您的账户激活成功");
            return modelAndView;
        }
        modelAndView.addObject("data","激活失败");
        return modelAndView;
    }
    /**
     * 将图片保存在服务器
     * @param file
     * @param request
     * @return
     */
    private String uploadFile(MultipartFile file,HttpServletRequest request){
        // 文件名及文件存储位置,保存到 ../resources/upload/ 目录下
        String fileName = UUID.randomUUID().toString()+"."+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        String filePath = request.getServletContext().getRealPath("/resources/upload");
        //文件上传到服务器
        try {
            file.transferTo(new File(filePath+File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
       //图片的路径
        String heading="/resources/upload/"+fileName;
        return heading;
    }
}
