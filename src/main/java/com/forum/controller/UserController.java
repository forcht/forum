package com.forum.controller;

import com.forum.entity.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * Created by haitang on 2017/6/5
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 用户注册
     * @param username
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/from/register",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView Register(@RequestParam("username") String username,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password){
        ModelAndView model=new ModelAndView();
        int flag=userService.Register(username,email,password);
        if(flag==-1){
            model.addObject("data","该邮箱已注册");
        }else if(flag==-2){
            model.addObject("data","该昵称已被使用");
        }
        if(flag>0){
            model.addObject("data","注册成功，请登录");
        }else if(flag==0){
            model.addObject("data","注册失败");
        }
        model.setViewName("register");
        return model;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/from/login",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session){
        ModelAndView model=new ModelAndView();
        model.setViewName("index");
        int flag=userService.checkLogin(username,password);
        if(flag==-1){
            model.addObject("data","该用户名不存在");
        }else if(flag==-2){
            model.addObject("data","输入的密码错误");
        }else{
            session.setAttribute("user",userService.findUserByName(username));
            model.setViewName("index");
        }
        return model;
    }

    /**
     * 修改用户名和密码
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/from/update",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updateUserInfo(@RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       HttpSession session){
        User user= (User) session.getAttribute("user");
        ModelAndView model=new ModelAndView();
        model.setViewName("login");
        int flag=userService.updateUserInfo(user.getUserId(),username,password);
        if(flag==-1){
            model.addObject("data","该昵称已被使用");
        }else if(flag==0){
            model.addObject("data","修改失败");
        }else {
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user",user);
        }
        return model;
    }
    @RequestMapping(value = "/from/updateHeading",method = RequestMethod.POST)
    public String updateHeading(HttpServletRequest request,@RequestParam("file") MultipartFile file){

        // 文件名及文件存储位置,保存到 ../resources/upload/ 目录下
        String fileName = UUID.randomUUID().toString()+"."+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        String filePath = request.getServletContext().getRealPath("/resources/upload");
        //文件上传到服务器
        try {
            file.transferTo(new File(filePath+File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //修改数据库中用户的头像
        String heading="/resources/upload/"+fileName;
       // HttpSession session=request.getSession();
       // User user= (User) session.getAttribute("user");
        //userService.updateUserHeading(user.getUserId(),heading);
       // user.setHeading(heading);
       // session.setAttribute("user",user);
        return "index";
    }
    @RequestMapping(value = "/")
    public String test(){
        return "login";
    }

    /**
     * 转发到登录页面
     * @return
     */
    @RequestMapping(value = "/to/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    /**
     * 转发到注册页面
     * @return
     */
    @RequestMapping(value ="/to/register",method = RequestMethod.GET)
    public  String toRegister(){
        return "register";
    }
}
