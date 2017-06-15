package com.forum.dao;

import com.forum.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by haitang on 2017/6/15.
 */
public interface ArticleDao {
    /**
     * 查找所有的文章
     * @return
     */
    List<Article> findAllArticle();

    /**
     * 添加文章
     * @param article
     * @return
     */
    int addArticle(@Param("article") Article article);
}
