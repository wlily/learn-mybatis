import com.wll.test.mybatis.dao.UserDao;
import com.wll.test.mybatis.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wll on 17-6-29.
 */
public class TestWithSpring {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @org.junit.Test
    public void test1() throws Exception {
        IUserService userService = (IUserService)ctx.getBean("userService");
        System.out.println(userService.selectUserByID(1));
        System.out.println(userService.getUserAticles(1));

        UserDao userDao = (UserDao)ctx.getBean("userMapper");
        System.out.println(userDao.selectUserByID(1));
        System.out.println(userDao.getUserAticles(1));

        userDao = (UserDao)ctx.getBean("userDao");
        System.out.println(userDao.selectUserByID(1));
        System.out.println(userDao.getUserAticles(1));
    }

    @org.junit.Test
    public void test2() throws Exception {
        UserDao userDao = (UserDao)ctx.getBean("userDaoImpl2");
        System.out.println(userDao.selectUserByID(1));
        System.out.println(userDao.selectUsers("gg"));
        System.out.println(userDao.selectAll());
    }

    @org.junit.Test
    public void test3() throws Exception {
        UserDao userDao = (UserDao)ctx.getBean("userDaoImpl3");
        System.out.println(userDao.selectUserByID(1));
        System.out.println(userDao.selectUsers("gg"));
        System.out.println(userDao.selectAll());
    }
}
