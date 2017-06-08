package com.forum.controller;

import com.forum.entity.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>06/05/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class UserControllerTest {

    @Autowired
    private UserController userController;
    private MockMvc mockMvc;
    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: Register(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password)
     */
    @Test
    public void testRegister() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/register")
                .param("username", "aa")
                .param("password", "aac")
                .param("email","aa"));
        ModelAndView modelAndView = resultActions.andReturn().getModelAndView();
        Map<String, Object> model = modelAndView.getModel();
        System.out.println(model + "," + modelAndView.getViewName());
    }

    /**
     * Method: updateUserInfo(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session)
     */
    @Test
    public void testUpdateUserInfo() throws Exception {
        User user=new User(8,"a2","aa","aa","aa");
        MockHttpSession session=new MockHttpSession();
        session.setAttribute("user",user);
        ModelAndView modelAndView = userController.updateUserInfo(user.getUsername(),user.getPassword(),session);
        System.out.println(modelAndView.getModel()+","+modelAndView.getViewName());
//        ResultActions resultActions = mockMvc.perform(post("/update")
//                .param("username", "aa")
//                .param("password", "aac"));
//        ModelAndView modelAndView = resultActions.andReturn().getModelAndView();
//        Map<String, Object> model = modelAndView.getModel();
//        System.out.println(model + "," + modelAndView.getViewName());
    }

    /**
     * Method: login(@RequestParam("username") String username, @RequestParam("password") String password)
     */
    @Test
    public void testLogin() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/login")
                .param("username", "aa")
                .param("password", "aac"));
        ModelAndView modelAndView = resultActions.andReturn().getModelAndView();
        Map<String, Object> model = modelAndView.getModel();
        System.out.println(model + "," + modelAndView.getViewName());
    }
    /**
     *
     * Method: updateHeading(HttpServletRequest request, @RequestParam("file") MultipartFile file)
     *
     */
    @Test
    public void testUpdateHeading() throws Exception {
        MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
        FileInputStream fis = new FileInputStream("D:/Desktop/my/a1.jpg");
        MockMultipartFile mfile = new MockMultipartFile("D:/Desktop/my/a1.jpg",fis);
        mockMvc.perform(fileUpload("/updateHeading", 1L).file(mfile));
        //userController.updateHeading(request,mfile);
    }
    /**
     * Method: test()
     */
    @Test
    public void testTest() throws Exception {
//TODO: Test goes here...
    }


} 
