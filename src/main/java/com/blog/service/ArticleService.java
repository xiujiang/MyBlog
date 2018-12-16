package com.blog.service;

import com.blog.base.BaseService;
import com.blog.dao.ArticleDao;
import com.blog.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:47
 */
@Service
public class ArticleService extends BaseService<Article> {

    ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao){
        super(articleDao);
        this.articleDao = articleDao;
    }



    public Page<Article> findAll(int pageNum,int size){
        Pageable pageable = PageRequest.of(pageNum,size);
        Page<Article> pageArticle = this.articleDao.findAll(pageable);
        return pageArticle;
    }

}
