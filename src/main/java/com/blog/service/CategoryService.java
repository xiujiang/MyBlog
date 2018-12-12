package com.blog.service;

import com.blog.base.BaseService;
import com.blog.dao.CategoryDao;
import com.blog.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:45
 */
@Service
public class CategoryService extends BaseService {

    @Autowired
    CategoryDao categoryDao;

    public void add(Category category){
        categoryDao.save(category);
    }
}
