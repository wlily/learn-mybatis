package com.wll.test.mybatis.cond2.service;

import com.wll.test.mybatis.cond2.dao.UserDao2;
import com.wll.test.mybatis.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wll on 17-6-29.
 */
@Service("userService2")
public class UserService2 {

    @Resource
    private UserDao2 userDao2;

    public User selectUserByID(int id){
        return userDao2.selectUserByID(1);
    }
}
