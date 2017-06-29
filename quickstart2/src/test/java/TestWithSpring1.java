import com.wll.test.mybatis.cond1.dao.UserDao;
import com.wll.test.mybatis.cond1.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wll on 17-6-29.
 */
public class TestWithSpring1 {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
    }

    @org.junit.Test
    public void test() throws Exception {
        IUserService userService = (IUserService)ctx.getBean("userService");
        System.out.println(userService.selectUserByID(1));
        System.out.println(userService.getUserAticles(1));
    }

    @org.junit.Test
    public void test1() throws Exception {
        UserDao userService = (UserDao)ctx.getBean("userMapper");
        System.out.println(userService.selectUserByID(1));
        System.out.println(userService.getUserAticles(1));
    }

    @org.junit.Test
    public void test2() throws Exception {
        UserDao userService = (UserDao)ctx.getBean("userDao");
        System.out.println(userService.selectUserByID(1));
        System.out.println(userService.getUserAticles(1));
    }
}
