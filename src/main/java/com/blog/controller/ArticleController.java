package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.domain.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:48
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/add")
    public void add(Article article){
        articleService.add(article);
    }
}
