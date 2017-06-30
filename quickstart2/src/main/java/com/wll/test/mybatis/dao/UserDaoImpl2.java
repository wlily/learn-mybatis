package com.wll.test.mybatis.dao;

import com.wll.test.mybatis.model.Article;
import com.wll.test.mybatis.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wll on 17-6-30.
 */
@Repository
public class UserDaoImpl2 implements UserDao{
    @Resource
    public SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }
    @Override
    public User selectUserByID(int id) throws Exception {
        return (User)sqlSession.selectOne(UserDao.class.getName() + ".selectUserByID", 1);
    }

    @Override
    public List<User> selectUsers(String userName) throws Exception {
        return sqlSession.selectList(UserDao.class.getName() + ".selectUsers", userName);
    }

    @Override
    public List<User> selectAll() throws Exception {
        return sqlSession.selectList(UserDao.class.getName() + ".selectAll");
    }

    @Override
    public void addUser(User user) {
        sqlSession.insert(UserDao.class.getName() + ".addUser", user);
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update(UserDao.class.getName() + ".updateUser", user);
    }

    @Override
    public void deleteUser(int id) {
        sqlSession.delete(UserDao.class.getName() + ".deleteUser", id);
    }

    @Override
    public List<Article> getUserAticles(int id) throws Exception {
        return sqlSession.selectList(UserDao.class.getName() + ".getUserAticles" + id);
    }
}
