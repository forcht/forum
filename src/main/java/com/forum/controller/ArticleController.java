package com.forum.controller;

import com.forum.entity.Article;
import com.forum.entity.Comment;
import com.forum.entity.User;
import com.forum.service.ArticleService;
import com.forum.service.CommentService;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by haitang on 2017/6/15.
 * 处理文章的controller
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    /**
     * 分页查询文章
     * @param currentPage
     * @return
     */
    @RequestMapping("list/{currentPage}")
    public ModelAndView getArticlePageList(@PathVariable("currentPage") int currentPage){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("articlePageBean",articleService.getArticlePageList(currentPage));
        modelAndView.setViewName("article/articleList");
        return modelAndView;
    }
    /**
     * 处理发表文章
     * @param title
     * @param lable
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView insertArticle(@RequestParam("title") String title,
                                      @RequestParam("lable") String lable,
                                      @RequestParam("content") String content,
                                      HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        User user= (User) request.getSession().getAttribute("user");
        Article article=new Article(title,content,new Date(),user.getUserId(),lable,1);
        articleService.insertArticle(article);
        List<Article> articles=articleService.getAllArticle();
        modelAndView.addObject("list",articles);
        modelAndView.setViewName("main");
        return modelAndView;
    }
    @RequestMapping(value = "details/{articleId}")
    public ModelAndView getArticleById(@PathVariable("articleId") Integer articleId){
        ModelAndView modelAndView=new ModelAndView();
        //获取帖子数据
        Article article=articleService.getArticleById(articleId);
        //获取帖子的评论
        List<Comment> commentList=commentService.getCommentByArticleId(articleId);
        modelAndView.addObject("article",article);
        modelAndView.addObject("commentList",commentList);
        modelAndView.setViewName("article/articleContent");
        return modelAndView;
    }
}
