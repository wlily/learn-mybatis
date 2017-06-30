package com.wll.test.mybatis.dao;

import com.wll.test.mybatis.model.Article;
import com.wll.test.mybatis.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wll on 17-6-29.
 */
@Repository
public class UserDaoImpl3 extends SqlSessionDaoSupport implements UserDao{
    // 注入SqlSessionTemplate实例
    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSession) {
        super.setSqlSessionTemplate(sqlSession);
    }

    //也可直接注入SqlSessionFactory实例，二者都指定时，SqlSessionFactory失效
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public User selectUserByID(int id){
        return this.getSqlSession().selectOne(UserDao.class.getName() + ".selectUserByID", 1);
    }

    @Override
    public List<User> selectUsers(String userName) throws Exception {
        return this.getSqlSession().selectList(UserDao.class.getName() + ".selectUsers", userName);
    }

    @Override
    public List<User> selectAll() throws Exception {
        return this.getSqlSession().selectList(UserDao.class.getName() + ".selectAll");
    }

    @Override
    public void addUser(User user) {
        this.getSqlSession().insert(UserDao.class.getName() + ".addUser", user);
    }

    @Override
    public void updateUser(User user) {
        this.getSqlSession().update(UserDao.class.getName() + ".updateUser", user);
    }

    @Override
    public void deleteUser(int id) {
        this.getSqlSession().delete(UserDao.class.getName() + ".deleteUser", id);
    }

    @Override
    public List<Article> getUserAticles(int id) throws Exception {
        return this.getSqlSession().selectList(UserDao.class.getName() + ".getUserAticles" + id);
    }
}
