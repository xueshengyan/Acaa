package xsy.acaa.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xsy.acaa.mapper.user.UserMapper;
import xsy.acaa.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2020/6/25.
 */
public class UserMapperTest {


    @Test
    public void test() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.getLoginUser("admin", "1234");
        System.out.println(user);

    }

    @Test
    public void test2() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user1:userList){
            System.out.println(user1);

        }
    }
    @Test
    public void test3() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.getUserById(String.valueOf(1));
        System.out.println(user);

    }
}
