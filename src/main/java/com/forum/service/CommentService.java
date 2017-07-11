package com.forum.service;

import com.forum.dao.CommentDao;
import com.forum.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haitang on 2017/6/25.
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    /**
     * 获取文章所有的评论
     * @param articleId
     * @return
     */
    public List<Comment> getCommentByArticleId(Integer articleId){
        return commentDao.getCommentByArticleId(articleId);
    }

    /**
     * 添加评论
     * @param content
     * @param articleId
     * @param userId
     * @return
     */
    public Map<String,String> addComment(String content, Integer articleId, Integer userId, HttpSession session){
        Map<String,String> map=new HashMap<>();
        if(session.getAttribute("user")==null){
            map.put("data","回复失败");
            return map;
        }
        int flag=commentDao.addComment(content,articleId,userId,new Date());
        if (flag>0){
            map.put("data","回复成功");
        }else{
            map.put("data","回复失败");
        }
        return map;
    }
}
