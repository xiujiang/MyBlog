package com.blog.domain;

import com.blog.base.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:39
 */
@Entity
@Table(name = "article")
@Data
public class Article extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author_id")
    private int authorId;

    @Column(name = "content_id")
    private int contentId;

    @Column(name = "click_num")
    private int clickNum;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    @Transient
    private String content;

    public Article(String title, int authorId, int contentId, String description,int clickNum) {
        this.title = title;
        this.authorId = authorId;
        this.contentId = contentId;
        this.clickNum = clickNum;
        this.description = description;
    }

    public Article() {
    }
}
