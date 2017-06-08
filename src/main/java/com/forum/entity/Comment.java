package com.forum.entity;

import java.util.Date;

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
