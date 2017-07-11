package com.forum.service;

import com.forum.dao.ArticleDao;
import com.forum.entity.Article;
import com.forum.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haitang on 2017/6/15.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 获得所有的文章
     * @return
     */
    public List<Article> getAllArticle() {
        List<Article> list=articleDao.findAllArticle();
        return list;
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    public int insertArticle(Article article){
        int flag=articleDao.addArticle(article);
        return flag;
    }

    /**
     * 分页获取文章
     * @param currentPage
     * @return
     */
    public PageBean getArticlePageList(int currentPage){
        //获得总记录数
        int count=articleDao.findAllArticle().size();
        //每页大小
        int pageSize=10;
        //计算出总页数
        int totalPage = (int) Math.ceil(count * 1.0 / pageSize);// 总页数
        List list=articleDao.getArticlePageList(currentPage,pageSize);
        PageBean pageBean=new PageBean(currentPage,totalPage,pageSize,count,list);
        return pageBean;
    }

    /**
     * 根据帖子Id获取帖子的数据
     * @param articleId
     * @return
     */
    public Article getArticleById(Integer articleId){
        return articleDao.getArticleById(articleId);
    }
}
