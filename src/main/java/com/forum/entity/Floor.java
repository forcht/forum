package com.forum.entity;

import java.util.Date;

/**
 * Created by haitang on 2017/6/4.
 * 评论表对应的实体(评论别人的评论)
 */
public class Floor {
    /**
     * 评论对应的ID
     */
    private Integer floorId;
    /**
     * 评论评论对应的ID
     */
    private Integer commentId;
    /**
     * 评论的作者的ID
     */
    private Integer userId;
    /**
     * 评论的内容
     */
    private String content;
    /**
     * 评论的时间
     */
    private Date date;

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
