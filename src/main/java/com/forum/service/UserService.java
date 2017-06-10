package com.forum.service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by haitang on 2017/6/4.
 * 处理用户的service
 */
public interface UserService {

    /**
     * 用户注册
     * @param username 用户名
     * @param email 用户邮箱
     * @param password 用户密码
     * @return ModelAndView
     */
    ModelAndView Register(String username, String email, String password);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    ModelAndView checkLogin(String username, String password, HttpServletRequest request);

    /**
     * 根据用户ID修改用户头像
     * @param request
     * @param file
     * @param username
     * @return
     */
    ModelAndView updateUserHeadingAndUsername(HttpServletRequest request, MultipartFile file, String username);

    /**
     * 激活用户
     * @param code
     */
    ModelAndView activateUser(String code);
}
