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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * Created by haitang on 2017/6/5
 */
@Controller
@RequestMapping("user")
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
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> Register(@RequestParam("username") String username,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password){
        Map<String,String> map=userService.Register(username,email,password);
        return map;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> login(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    HttpSession session){
        Map<String,String> map=userService.Login(username,password,session);
        return map;
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

    /**
     * 用户退出
     * @param session
     * @return
     */
    @RequestMapping(value = "/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
