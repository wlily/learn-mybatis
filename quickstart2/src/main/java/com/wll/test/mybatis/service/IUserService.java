package com.wll.test.mybatis.service;

import com.wll.test.mybatis.entity.Article;
import com.wll.test.mybatis.entity.User;

import java.util.List;

/**
 * Created by wll on 17-6-29.
 */
public interface IUserService {
    User selectUserByID(int id) throws Exception;
    List<User> selectUsers(String userName) throws Exception;
    List<User> selectAll() throws Exception;
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);

    List<Article> getUserAticles(int id) throws Exception;
}
