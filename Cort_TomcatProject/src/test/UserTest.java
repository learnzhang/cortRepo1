package test;

import domain.User;
import org.junit.Test;

public class UserTest {
    @Test
    public void userTest(){
        User user = new User(2,"李四","123456","male");
        System.out.println(new User(1,"张三","123456","male"));
		System.out.println(user);
    }
}
