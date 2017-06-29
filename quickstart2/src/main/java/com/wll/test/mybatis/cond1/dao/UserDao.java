package com.wll.test.mybatis.cond1.dao;

import com.wll.test.mybatis.model.Article;
import com.wll.test.mybatis.model.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by wll on 17-6-28.
 */
@MapperScan
public interface UserDao {
    User selectUserByID(int id) throws Exception;
    List<User> selectUsers(String userName) throws Exception;
    List<User> selectAll() throws Exception;
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);

    List<Article> getUserAticles(int id) throws Exception;
}