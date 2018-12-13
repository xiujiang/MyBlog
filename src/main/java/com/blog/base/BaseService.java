package com.blog.base;

import java.time.LocalDateTime;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:46
 */
public abstract class BaseService<T> {

    private BaseDao<T> dao;

    public BaseService(BaseDao baseDao){
        this.dao= baseDao;
    }

    public T add(T data){
        if(data instanceof BaseDomain){
            ((BaseDomain) data).setCreateTime(LocalDateTime.now());
            ((BaseDomain) data).setLastUpdateTime(LocalDateTime.now());
        }
        data = this.dao.save(data);
        return data;
    }

}
