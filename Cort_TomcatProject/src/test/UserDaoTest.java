package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {


    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("张三");
        loginuser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
