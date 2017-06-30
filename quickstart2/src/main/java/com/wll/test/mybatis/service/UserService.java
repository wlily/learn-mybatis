package com.wll.test.mybatis.service;

import com.wll.test.mybatis.entity.Article;
import com.wll.test.mybatis.entity.User;
import com.wll.test.mybatis.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wll on 17-6-29.
 */
@Service("userService")
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public User selectUserByID(int id) throws Exception {
        return userDao.selectUserByID(id);
    }

    @Override
    public List<User> selectUsers(String userName) throws Exception {
        return userDao.selectUsers(userName);
    }

    @Override
    public List<User> selectAll() throws Exception {
        return userDao.selectAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<Article> getUserAticles(int id) throws Exception {
        return userDao.getUserAticles(id);
    }
}
