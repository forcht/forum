package com.forum.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by haitang on 2017/6/4.
 * 评论表对应的实体类
 */
public class Comment {
    /**
     * 评论的ID
     */
    private Integer commentId;
    /**
     * 评论的内容
     */
    private String content;
    /**
     * 评论的文章的ID
     */
    private Integer articleId;
    /**
     * 发表评论的作者的ID
     */
    private Integer userId;
    /**
     * 评论发表的时间
     */
    private Date date;
    /**
     * 评论的作者
     */
    private User user;
    /**
     * 楼中楼评论
     */
    List<Floor> floors;

    public Comment() {
    }

    public Comment(String content, Integer articleId, Integer userId, Date date) {
        this.content = content;
        this.articleId = articleId;
        this.userId = userId;
        this.date = date;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
