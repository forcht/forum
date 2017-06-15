package com.forum.service;

import com.forum.dao.ArticleDao;
import com.forum.entity.Article;
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
}
