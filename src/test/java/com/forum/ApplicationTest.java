package com.forum;

import com.forum.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by haitang on 2017/6/4.
 */
public class ApplicationTest {

    private ApplicationContext context;
    @Before
    public void start(){
        context= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    @Test
    public void testApplication(){
        Assert.assertNotNull(context.getBean(UserDao.class));
        Assert.assertNotNull(context.getBean("sqlSessionFactory"));
    }
}
