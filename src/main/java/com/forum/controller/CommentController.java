package com.forum.controller;

import com.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haitang on 2017/6/25.
 */
@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addComment(@RequestParam("content") String content,
                                         @RequestParam("articleId") Integer articleId,
                                         @RequestParam("userId") Integer userId,
                                         HttpSession session){
        Map<String,String> map=commentService.addComment(content,articleId,userId,session);
        return  map;
    }
}
