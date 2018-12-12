package com.blog.dao;

import com.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:44
 */
public interface ArticleDao extends JpaRepository<Article,Long> {
}
