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
 * Date:2018/12/11
 * Time:23:38
 */
@Entity
@Table(name = "user")
@Data
public class User extends BaseDomain {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name="create_time")
    private LocalDateTime createTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    @Column(name = "remark")
    private String remark;


}
