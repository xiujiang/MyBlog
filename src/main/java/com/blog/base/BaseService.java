package com.blog.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:46
 */
public abstract class BaseService<T> {

    private BaseDao<T> dao;

    public void add(T data){
        this.dao.save(data);
    }

}
