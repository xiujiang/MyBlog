package com.blog.domain;

import com.blog.base.BaseDomain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * author:xiujiang.liu
 * Date:2018/12/16
 * Time:21:33
 */
@Entity
@Data
@Table(name = "content")
public class Content extends BaseDomain {

    @Id
    private int id;

    /**
     * 文章内容
     */
    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    public Content(String content) {
        this.content = content;
    }


}
