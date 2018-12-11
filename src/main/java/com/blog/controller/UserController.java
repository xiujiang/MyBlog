package com.blog.controller;

import com.blog.base.BaseController;
import com.blog.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.blog.service.UserService;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:49
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public void login(User user){
        logger.info("user信息为:{}",user);
        userService.save(user);
        logger.info("登录成功");
    }

}
