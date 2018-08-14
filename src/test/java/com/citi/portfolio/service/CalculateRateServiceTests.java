package com.citi.portfolio.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.CalculateRateService;
import com.citi.portfoliomanager.service.IService.IPortfolioService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring.xml",
        "file:src/main/webapp/WEB-INF/spring-mybatis.xml",
})
public class CalculateRateServiceTests {
	@Autowired
    private CalculateRateService calculateRateService;

    @Test
    public void sortportfolioByRateOfReturn() throws Exception {
    	calculateRateService.sortportfolioByRateOfReturn();
    }
}
