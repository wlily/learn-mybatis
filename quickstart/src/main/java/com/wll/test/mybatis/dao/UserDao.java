package com.wll.test.mybatis.dao;

import java.util.List;

/**
 * Created by wll on 17-6-28.
 */
public interface UserDao {
    User selectUserByID(int id) throws Exception;
    List<User> selectUsers(String userName) throws Exception;
    List<User> selectAll() throws Exception;
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);

    List<Article> getUserAticles(int id) throws Exception;
}
