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
        ModelAndView modelAndView=userService.Register(username,email,password);
        modelAndView.setViewName("register");
        return modelAndView;
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
                               HttpServletRequest request){
        ModelAndView modelAndView=userService.checkLogin(username,password,request);
        return modelAndView;
    }

    /**
     * 修改用户信息，修改头像和昵称
     * @param request
     * @param file
     * @return
     */
    @RequestMapping(value = "/from/updateUserInfo",method = RequestMethod.POST)
    public ModelAndView updateUserHeadingAndUsername(HttpServletRequest request,
                                @RequestParam(value = "file",required = false) MultipartFile file,
                                @RequestParam("username") String username){
       ModelAndView modelAndView=userService.updateUserHeadingAndUsername(request,file,username);
       modelAndView.setViewName("updateUserInfo");
        return modelAndView;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @RequestMapping(value = "/activateUser")
    public ModelAndView activateUser(@RequestParam(value = "code",required = false) String code,HttpServletRequest request){
        ModelAndView modelAndView=userService.activateUser(code);
        User user= (User) modelAndView.getModel().get("user");
        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
        }
        modelAndView.setViewName("main");
        return modelAndView;
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
