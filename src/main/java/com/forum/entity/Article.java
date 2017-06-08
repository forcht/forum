package com.forum.entity;

import java.util.Date;

/**
 * Created by haitang on 2017/6/4.
 * 文章表对应的实体类
 */
public class Article {
    /**
     * 文章的id
     */
    private Integer articleId;
    /**
     * 文章的标题
     */
    private String title;
    /**
     * 文章的内容
     */
    private String content;
    /**
     * 文章发表的日期
     */
    private Date date;
    /**
     * 发表文章的作者的id
     */
    private Integer userId;
    /**
     * 文章的标签
     */
    private String lable;
    /**
     * 文章的状态，置顶1，加精2，置顶加精3
     */
    private Integer status;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
