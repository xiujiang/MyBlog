package com.blog.service;

import com.blog.base.BaseService;
import com.blog.dao.ArticleDao;
import com.blog.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:47
 */
@Service
public class ArticleService extends BaseService<Article> {

    @Autowired
    public ArticleService(ArticleDao articleDao){
        super(articleDao);
    }

}
