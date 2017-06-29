import com.wll.test.mybatis.cond1.dao.UserDao;
import com.wll.test.mybatis.cond1.service.IUserService;
import com.wll.test.mybatis.cond2.service.UserService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wll on 17-6-29.
 */
public class TestWithSpring2 {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
    }

    @org.junit.Test
    public void test1() throws Exception {
        UserService2 userService = (UserService2)ctx.getBean("userService2");
        System.out.println(userService.selectUserByID(1));
    }
}
