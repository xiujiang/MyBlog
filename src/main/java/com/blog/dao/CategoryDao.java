package com.blog.dao;

import com.blog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author:xiujiang.liu
 * Date:2018/12/12
 * Time:23:44
 */
public interface CategoryDao extends JpaRepository<Category,Long> {

}
