package com.blog.dao;

import com.blog.base.BaseDao;
import com.blog.domain.User;
import org.springframework.data.jpa.repository.Query;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:41
 */
public interface UserDao extends BaseDao<User> {

    @Query(value = "select * from user where email = ?1 and password = ?2",nativeQuery = true)
    public User findUserByEmailAndPsd(String email,String password);

}
