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
     * 分页查找文章
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Article> getArticlePageList(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);
    /**
     * 添加文章
     * @param article
     * @return
     */
    int addArticle(@Param("article") Article article);

    /**
     * 根据帖子Id获取帖子的数据
     * @param articleId
     * @return
     */
    Article getArticleById(@Param("articleId") Integer articleId);
}
