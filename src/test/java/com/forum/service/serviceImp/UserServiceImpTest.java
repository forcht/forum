package com.forum.service.serviceImp;

import com.forum.entity.User;
import com.forum.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserServiceImp Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>06/05/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class UserServiceImpTest {

    @Autowired
    private UserService userService;

    /**
     * Method: Register(String username,String email,String password)
     */
    @Test
    public void testRegister() throws Exception {
        User user=new User(11,"a1","a1","a1","a1");
        System.out.println(userService.Register(user.getUsername(),user.getEmail(),user.getPassword()));
    }

    /**
     * Method: findUser(String username, String password)
     */
    @Test
    public void testCheckLogin() throws Exception {
        String username="a1";
        String password="a1";
        System.out.println(userService.checkLogin(username,password));
    }

    /**
     * Method: findUserById(Integer userId)
     */
    @Test
    public void testFindUserById() throws Exception {

    }

    /**
     * Method: findUserByName(String username)
     */
    @Test
    public void testFindUserByName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateUserInfo(Integer userId, String username, String password)
     */
    @Test
    public void testUpdateUserInfo() throws Exception {
        Integer userId=1;
        String username="cc";
        String password="cd";
        System.out.println(userService.updateUserInfo(userId,username,password));
    }

    /**
     * Method: updateUserHeading(Integer userId, String heading)
     */
    @Test
    public void testUpdateUserHeading() throws Exception {

    }


} 
