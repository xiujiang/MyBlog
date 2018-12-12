package com.blog.service;

import com.blog.base.BaseService;
import com.blog.dao.CommentDao;
import com.blog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:48
 */
@Service
public class CommentService extends BaseService {

    @Autowired
    CommentDao commentDao;

    public void add(Comment comment){
        this.commentDao.save(comment);
    }
}
