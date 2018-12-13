package com.blog.service;

import com.blog.base.BaseService;
import com.blog.dao.UserDao;
import com.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:45
 */
@Service
public class UserService extends BaseService<User> {
    UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        super(userDao);
        this.userDao=userDao;
    }


    public void save(User user){
        userDao.save(user);
    }
}
