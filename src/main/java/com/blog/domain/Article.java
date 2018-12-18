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
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "status")
    private Enum status;

    @Column(name = "click_num")
    private Integer clickNum;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;


    @Transient
    private String content;

    public Article(String title, Integer authorId, Integer categoryId,Integer contentId, String description,Integer clickNum,Enum status) {
        this.title = title;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.contentId = contentId;
        this.clickNum = clickNum;
        this.description = description;
        this.status = status;
    }

    public Article() {
    }
}
