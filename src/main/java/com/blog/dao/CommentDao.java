package com.blog.dao;

import com.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:45
 */
public interface CommentDao extends JpaRepository<Comment,Long> {
}
