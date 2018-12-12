package com.blog.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:41
 */
@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    private int id;

    @Column(name = "article_id")
    private int articleId;

    @Column(name = "reply_author_id")
    private int replyAuthorId;

    @Column(name = "content")
    private int content;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

}
