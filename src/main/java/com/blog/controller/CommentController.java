package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.domain.Comment;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:49
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    public void add(Comment comment){
        commentService.add(comment);
    }

}
