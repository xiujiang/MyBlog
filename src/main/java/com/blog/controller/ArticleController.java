package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.base.BaseService;
import com.blog.base.Response;
import com.blog.domain.Article;
import com.blog.domain.Content;
import com.blog.enums.ArticleEnum;
import com.blog.service.ArticleService;
import com.blog.service.ContentService;
import com.blog.service.UserService;
import org.omg.PortableInterceptor.ACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/addArticle")
    @ResponseBody
    public Response addArticle(Integer authorId,Integer categoryId, String title, String content){

        logger.info("authorId:{},title:{},content:{}",authorId,title,content);

        if(authorId == 0 || StringUtils.isEmpty(title) || StringUtils.isEmpty(content)){
            return new Response("10","文章信息为空",null);
        }
        if(!userService.isExist(authorId)){
            return new Response("10","用户信息不存在",null);
        }

        Content newContent = new Content(content);
        newContent = contentService.add(newContent);
        Article article = new Article(title,authorId,categoryId,newContent.getId(),content.substring(0,content.length()>=60?60:content.length())+".....",0, ArticleEnum.ACTIVE);
        articleService.add(article);
        return new Response().success(article);
    }

    @GetMapping("/updateArticle")
    @ResponseBody
    public Response updateArticle(int articleId,String title,String content){
        Article article = articleService.get(articleId);
        if (!StringUtils.isEmpty(content)) {
            article.setDescription(content.substring(0,content.length()>=60?60:content.length())+".....");
            contentService.update(article.getContentId(),content);
        }
        if(!StringUtils.isEmpty(title) && !title.equals(article.getTitle())){
            article.setTitle(title);
        }
        this.articleService.update(article);
        return new Response().success(article);
    }

    /**
     * 根据分类信息查询文章
     * @param pageNum
     * @param categoryId
     * @return
     */
    @GetMapping("/findAllByCategory")
    public Response findAllByCategory(int pageNum,int categoryId){
        Page<Article> articles = articleService.findAll(pageNum,20,new Article(null,null,categoryId,null,null,null,null));
        return new Response().success(articles);
    }



    /**
     * 分页查询文章
     * @param pageNum
     * @return
     */
    @GetMapping("/findAllArticle")
    @ResponseBody
    public Response findAllArticle(int pageNum){
        Page<Article> articlePage = this.articleService.findAll(pageNum,10,new Article());
        logger.info("articlePage"+articlePage);
        return new Response().success(articlePage);
    }

    /**
     * 获取单条文章
     * @param articleId
     * @return
     */
    @GetMapping("/articleInfo")
    @ResponseBody
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
