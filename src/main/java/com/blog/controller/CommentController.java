package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.base.BaseService;
import com.blog.domain.Comment;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:49
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController<Comment> {
    @Autowired
    public CommentController(CommentService commentService) {
        super(commentService);
    }

}
