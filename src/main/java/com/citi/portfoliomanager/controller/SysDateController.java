package com.citi.portfoliomanager.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@Controller
public class SysDateController {
	private static final Logger logger= LogManager.getLogger(SysDateController.class);
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    @CrossOrigin
	    @RequestMapping(value = "/nextDate ",method = RequestMethod.GET)
	    @ResponseBody
	    public String nextDate() {
	    	SystemDate.dayPass();
	    	JSONObject jsonObject = new JSONObject();
	    	jsonObject.put("success", true);
	    	jsonObject.put("date", formatter.format(SystemDate.getSysDate()));
	    	return jsonObject.toString();
	    }
}
