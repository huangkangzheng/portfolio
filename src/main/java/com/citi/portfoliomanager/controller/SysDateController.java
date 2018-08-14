package com.citi.portfoliomanager.controller;

import java.text.SimpleDateFormat;

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
import com.citi.portfoliomanager.constant.StatusConstant;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.CalculateRateService;

@Controller
public class SysDateController {
	private static final Logger logger= LogManager.getLogger(SysDateController.class);
	
	@Autowired
	private CalculateRateService calculateRateService;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    @CrossOrigin
	    @RequestMapping(value = "/nextDate ",method = RequestMethod.GET)
	    @ResponseBody
	    public String nextDate() {
	    	
	    	JSONObject jsonObject = new JSONObject();
	    	if(calculateRateService.updatePortfolioHistory()) {
	    	  SystemDate.dayPass();
	    	  jsonObject.put("success", true);
	    	  jsonObject.put("date", formatter.format(SystemDate.getSysDate()));
	    	  logger.info("what a nice day");
	    	}else {
	    		jsonObject.put("success", false);
		    	  jsonObject.put("date", formatter.format(SystemDate.getSysDate()));
		    	  logger.error("what a bad day");
	    	}
	    	 return jsonObject.toString();
	    }
}
