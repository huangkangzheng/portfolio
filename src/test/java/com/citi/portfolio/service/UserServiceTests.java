package com.citi.portfolio.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.PullHistoryDataService;
import com.citi.portfoliomanager.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring.xml",
        "file:src/main/webapp/WEB-INF/spring-mybatis.xml",
})
public class UserServiceTests {

    @Autowired
	private UserService service;



    @Test
    public void getUser() throws Exception {
    	List<User> user=service.getUsers(1);
    	assertNotEquals(user.size(), 0);
    }
    
    @Test
    public void createUser() throws Exception {
    	User user=new User();
    	user.setUsername("test");
    	user.setPassword("test");
    	user.setType(0);
    	user.setIntialAsset(new BigDecimal("10000"));
    	user.setCash(new BigDecimal("10000"));
    	user.setStatus(0);
    	assertTrue(service.createUser(user));
    }
    
    @Test
    public void updateUser() throws Exception {
    	User user=new User();
    	user.setUsername("test");
    	user.setPassword("passs");
    	user.setType(0);
    	user.setIntialAsset(new BigDecimal("10000"));
    	user.setCash(new BigDecimal("10000"));
    	user.setStatus(0);
    	assertTrue(service.createUser(user));
    }
    
}