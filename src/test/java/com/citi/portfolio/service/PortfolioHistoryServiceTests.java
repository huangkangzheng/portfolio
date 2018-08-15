package com.citi.portfolio.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.service.IService.IPortfolioHistoryService;
import com.citi.portfoliomanager.service.IService.IPositionService;
import com.citi.portfoliomanager.service.IService.IProductHistoryService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring.xml",
        "file:src/main/webapp/WEB-INF/spring-mybatis.xml",
})
public class PortfolioHistoryServiceTests {
	    @Autowired
	    private IPortfolioHistoryService productHistoryService; 
	
	   @Test
	    public void ProductHistoryService() throws Exception {
		   assertNotNull( productHistoryService.listPortfolioHistory(2));
	    }

         
}
