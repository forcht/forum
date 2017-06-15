package com.forum.controller;

import com.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by haitang on 2017/6/15.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

}
