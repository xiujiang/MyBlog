package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.base.BaseService;
import com.blog.domain.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:50
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController<Category> {

    @Autowired
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
