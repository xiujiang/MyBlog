package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.domain.User;
/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:41
 */
public interface UserDao extends JpaRepository<User, Long> {

}
