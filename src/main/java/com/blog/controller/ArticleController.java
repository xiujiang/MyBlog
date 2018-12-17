package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.base.BaseService;
import com.blog.base.Response;
import com.blog.domain.Article;
import com.blog.domain.Content;
import com.blog.service.ArticleService;
import com.blog.service.ContentService;
import com.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 文章
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:48
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController<Article> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    ArticleService articleService;

    @Autowired
    ArticleController(ArticleService articleService) {
        super(articleService);
        this.articleService = articleService;
    }

    @Autowired
    UserService userService;

    @Autowired
    ContentService contentService;

    @PostMapping("/addArticle")
    public Response addArticle(Integer authorId, String title, String content){

        logger.info("authorId:{},title:{},content:{}",authorId,title,content);

        if(authorId == 0 || StringUtils.isEmpty(title) || StringUtils.isEmpty(content)){
            return new Response("10","文章信息为空",null);
        }
        if(!userService.isExist(authorId)){
            return new Response("10","用户信息不存在",null);
        }

        Content newContent = new Content(content);
        newContent = contentService.add(newContent);
        Article article = new Article(title,authorId,newContent.getId(),content.substring(0,content.length()>=60?60:content.length())+".....",0);
        articleService.add(article);
        return new Response().success(article);
    }

    @PostMapping("/updateArticle")
    public Response updateArticle(Article article,String content){
        int contentId = article.getContentId();
        if (contentId != 0) {
            contentService.update(article.getContentId(),content);
        }

        this.articleService.update(article);
        return new Response().success(article);
    }

    /**
     * 分页查询文章
     * @param pageNum
     * @return
     */
    @PostMapping("/findAllArticle")
    public Response findAllArticle(int pageNum){
        Page<Article> articlePage = this.articleService.findAll(pageNum,20);
        return new Response().success(articlePage);
    }

    /**
     * 获取单条文章
     * @param articleId
     * @return
     */
    @PostMapping("/articleInfo")
    public Response getContentById(int articleId){
        logger.info("id:{}",articleId);
        Article article = this.articleService.get(articleId);
        if(ObjectUtils.isEmpty(article)){
            return new Response("10","文章不存在",null);
        }
        logger.info("article:{}",article);
        Content content = this.contentService.get(article.getContentId());
        logger.info("content:{}",content);
        if(!ObjectUtils.isEmpty(content)){
            article.setContent(content.getContent());
        }
        return new Response().success(article);
    }
}
