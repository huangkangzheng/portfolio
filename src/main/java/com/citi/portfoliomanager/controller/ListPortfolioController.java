package com.citi.portfoliomanager.controller;

import java.util.List;

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
import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.Position;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.ICalculateRateService;
import com.citi.portfoliomanager.service.IService.IPortfolioService;
import com.citi.portfoliomanager.service.IService.IPositionService;

@Controller
public class ListPortfolioController {
	   
	 private static final Logger logger= LogManager.getLogger(ListPortfolioController.class);
	
	    @Autowired
	    private ICalculateRateService calculateService;

	   @CrossOrigin
	    @RequestMapping(value = "listSortedPortfolios",method = RequestMethod.GET)
	    @ResponseBody
	    public String listSortedPortfolios(){
		   logger.info("listSortedPortfolios");
	        JSONObject result=new JSONObject();
	        List<Portfolio> res=calculateService.sortportfolioByRateOfReturn();
	        result.put("success", true);
	        result.put("data", res);
	        return result.toString();
	    }
	   
	   @CrossOrigin
	    @RequestMapping(value = "listPositionByPortfolio",method = RequestMethod.GET)
	    @ResponseBody
	    public String listPositionByPortfolio(@RequestParam(value = "portfolioId")int portfolioId){
		   logger.info("listPositionByPortfolio");
	        JSONObject result=new JSONObject();
	        List<Position> res=calculateService.listPositionByPortfolio(portfolioId);
	        result.put("success", true);
	        result.put("data", res);
	        return result.toJSONStringWithDateFormat(result, "yyyy/MM/dd");
	    }
}
