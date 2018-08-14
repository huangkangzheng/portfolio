package com.citi.portfolio.service;

import com.citi.portfolio.AppTests;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IPortfolioService;
import com.citi.portfoliomanager.util.JSONUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by hkz on 2018/8/13.
 */
public class PortfolioServiceTests extends AppTests{
    private MockMvc mockMvc;

    @Autowired
    private IPortfolioService portfolioService;

    @Test
    public void createPortfolio() throws Exception {
        User user =new User();
        user.setUserId(2);
        portfolioService.createPortfolio(user,"portfolio1",10000000.0,0);
    }

    @Test
    public void queryRate() throws Exception{
        System.out.println(JSONUtil.toJsonString(portfolioService.queryRate(1,"Nikkei")));
    }
}
