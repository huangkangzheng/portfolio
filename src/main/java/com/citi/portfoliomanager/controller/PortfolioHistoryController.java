package com.citi.portfoliomanager.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.service.IService.IPortfolioHistoryService;
import com.citi.portfoliomanager.service.IService.IPositionService;
import com.citi.portfoliomanager.service.IService.IProductHistoryService;

@Controller
public class PortfolioHistoryController {
	 private static final Logger logger= LogManager.getLogger(PortfolioHistoryController.class);

	    @Autowired
	    private IPortfolioHistoryService portfolioHistoryService;

	    @CrossOrigin
	    @RequestMapping(value = "/listPortfolioHistoryByPortfolio",method = RequestMethod.GET)
	    @ResponseBody
	    public String listPortfolioHistoryByPortfolio(@RequestParam(value = "portfolioId")int portfolioId){
	        logger.info("listPortfolioHistoryByPortfolio:"+portfolioId);
	        JSONObject result=new JSONObject();
	        result.put("success",true);
	        result.put("data",portfolioHistoryService.listPortfolioHistory(portfolioId));
	        return JSONObject.toJSONStringWithDateFormat(result, "yyyy/MM/dd");
	    }
}
