package com.forum.entity;

/**
 * Created by haitang on 2017/6/4.
 * 用户表对应的实体类
 */
public class User {

    /**
     * 用户的id
     */
    private Integer userId;
    /**
     * 用户的昵称
     */
    private String username;
    /**
     * 用户的密码
     */
    private String password;
    /**
     * 用户的邮箱
     */
    private String email;
    /**
     * 用户的头像
     */
    private String heading;
    /**
     * 用户的激活码
     */
    private String code;
    /**
     * 用户的状态，0为还没激活，1为已激活
     */
    private int state;

    public User(Integer userId, String username, String password, String email, String heading, String code, int state) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.heading = heading;
        this.code = code;
        this.state = state;
    }
    public User(){

    }
    public User(String username, String password, String email, String heading,String code) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.heading = heading;
        this.code=code;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", heading='" + heading + '\'' +
                '}';
    }
}
