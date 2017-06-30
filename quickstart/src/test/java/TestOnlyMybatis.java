import com.wll.test.mybatis.entity.User;
import com.wll.test.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by wll on 17-6-28.
 */
public class TestOnlyMybatis {

    @org.junit.Test
    public void test() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        try{
            UserDao userDao = session.getMapper(UserDao.class);

            User user = new User();
            user.setUserName("gg");
            user.setUserAge("30");
            user.setUserAddress("Shanghai");
            userDao.addUser(user);
            session.commit();
            System.out.println("当前增加的用户id为: " + user.getId());

            User user2 = userDao.selectUserByID(4);
            user2.setUserAddress("原来是哈哈哈");
            userDao.updateUser(user2);
            session.commit();

            userDao.deleteUser(2);
            session.commit();

            System.out.println(userDao.selectAll());

            System.out.println(userDao.selectUserByID(1));
            System.out.println(userDao.selectUsers("summer"));

            System.out.println(userDao.getUserAticles(1));
        }
        finally {
            session.close();
        }
    }

    @org.junit.Test
    public void test2() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        try{
            String nameSpace = UserDao.class.getName();

            User user = new User();
            user.setUserName("gg");
            user.setUserAge("30");
            user.setUserAddress("Shanghai");

            session.insert(nameSpace + ".addUser", user);
            session.commit();
            System.out.println("当前增加的用户id为: " + user.getId());

            User user2 = session.selectOne(nameSpace + ".selectUserByID", 4);
            user2.setUserAddress("原来是哈哈哈");
            session.update(nameSpace + ".updateUser", user2);
            session.commit();

            session.delete(nameSpace + ".deleteUser", 2);
            session.commit();

            System.out.println((User)session.selectOne(nameSpace + ".selectUserByID", 1));
            System.out.println(session.selectList(nameSpace + ".selectAll"));
            System.out.println(session.selectList(nameSpace + ".selectUsers", "gg"));
            System.out.println(session.selectList(nameSpace + ".getUserAticles", 1));
        }
        finally {
            session.close();
        }
    }
}
