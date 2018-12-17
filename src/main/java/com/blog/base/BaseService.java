package com.blog.base;

import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Example;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Optional;

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
        data = this.dao.saveAndFlush(data);

        System.out.println("data:"+data);

        return data;
    }

    public T update(T data){
        if(data instanceof BaseDomain){
            ((BaseDomain) data).setLastUpdateTime(LocalDateTime.now());
        }
        T newData = this.dao.getOne(((BaseDomain)data).getId());
        if(ObjectUtils.isEmpty(newData)){
            return data;
        }
        data = this.dao.save(data);
        return data;
    }

    public T get(int id){
        if (id == 0) {
            return null;
        }
        Optional<T> t = this.dao.findById(id);
        if(t.isPresent()){
            return t.get();
        }else{
            return null;
        }
    }

}
