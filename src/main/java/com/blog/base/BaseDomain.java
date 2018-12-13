package com.blog.base;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * author:xiujiang.liu
 * Date:2018/12/13
 * Time:23:42
 */
@Data
public abstract class BaseDomain {
    private int id;

    private LocalDateTime createTime;

    private LocalDateTime lastUpdateTime;

}
