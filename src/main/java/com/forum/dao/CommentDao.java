package com.forum.dao;

import com.forum.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by haitang on 2017/6/25.
 */
public interface CommentDao {

    /**
     * 获取文章所有的评论
     * @param articleId
     * @return
     */
    List<Comment> getCommentByArticleId(@Param("articleId") Integer articleId);

    /**
     * 添加评论
     * @param content
     * @param articleId
     * @param userId
     * @return
     */
    int addComment(@Param("content") String content,
                   @Param("articleId") Integer articleId,
                   @Param("userId") Integer userId,
                   @Param("date") Date date);
}
