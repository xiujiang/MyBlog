package com.blog.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:38
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
