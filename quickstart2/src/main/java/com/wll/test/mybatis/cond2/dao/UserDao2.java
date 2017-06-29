package com.wll.test.mybatis.cond2.dao;

import com.wll.test.mybatis.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wll on 17-6-29.
 */
@Repository("userDao2")
public class UserDao2 extends SqlSessionDaoSupport{
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public User selectUserByID(int id){
        return this.getSqlSession().selectOne(this.getClass().getName() + ".selectUserByID", 1);
    }
}
