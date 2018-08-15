package com.citi.portfoliomanager.controller;

import java.math.BigDecimal;

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
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IUserService;

@Controller
public class UserController {
    private static final Logger logger= LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    
    @CrossOrigin
    @RequestMapping(value = "/listUsers",method = RequestMethod.GET)
    @ResponseBody
    public String getUsers(@RequestParam("type") int type){
    	JSONObject jsonObject = new JSONObject();
    	logger.info("listUsers by ");
    	jsonObject.put("success",true);
    	jsonObject.put("data",userService.getUsers(type));
        return jsonObject.toString();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/createUser ",method = RequestMethod.GET)
    @ResponseBody
    public String createUser(@RequestParam("name") String name,@RequestParam("password") String password
    		,@RequestParam("initCash") String initCash){
    	User user=new User();
    	logger.info("create a user "+name+" with "+initCash);
    	user.setUsername(name);
    	user.setPassword(password);
    	user.setType(0);
    	BigDecimal bg;
    	JSONObject jsonObject = new JSONObject();
    	try {
    	bg=new BigDecimal(initCash);
    	}catch(NumberFormatException e) {
    		jsonObject.put("success", false);
    		jsonObject.put("info",StatusConstant.PARAMETER_PARSE_ERROR);
    		logger.info("NumberFormatException "+initCash);
    		 return jsonObject.toString();
    	}
    	user.setIntialAsset(new BigDecimal(initCash));
    	user.setCash(new BigDecimal(initCash));
    	user.setStatus(0);
    	jsonObject.put("success", userService.createUser(user));
        return jsonObject.toString();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/updatePassword ",method = RequestMethod.GET)
    @ResponseBody
    public String updatePassword(@RequestParam("oldPassword") String old,@RequestParam("newPassword") String newP,@RequestParam("userId") int userId) {
    	User user=userService.getUser(userId);
    	JSONObject jsonObject = new JSONObject();
    	if(user==null) {
    		logger.info("ghost login user");
    		jsonObject.put("success", false);
    		return jsonObject.toString(); 
    		
    	}
    	if(!user.getPassword().equals(old)) {
    		logger.info("wrong password");
    		jsonObject.put("success", false);
    		jsonObject.put("info",StatusConstant.PASSWORD_INVALID );
    		return jsonObject.toString();
    	}
    	logger.info("update  user password "+user.getUserId());
        boolean tag=userService.updateUser(user.getUserId(),newP);
        if(!tag) {
			jsonObject.put("info",StatusConstant.DATABASE_ERROR_OR_NO_DATA );
		}else {
		  jsonObject.put("success",tag );
		  user.setPassword(newP);
		}
        return jsonObject.toString();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/deleteManager ",method = RequestMethod.GET)
    @ResponseBody
    public String deleleManager(@RequestParam("userId") int id) {
    	JSONObject jsonObject = new JSONObject();
    	
    		User user=userService.getUser(id);
    		if(user==null) {
    			logger.info("no such userId "+id);
    			jsonObject.put("success", false);
    		}else {
    		user.setStatus(1);
    		boolean tag=userService.updateUser(user.getUserId(),1);
    		if(!tag) {
    			jsonObject.put("info",StatusConstant.DATABASE_ERROR_OR_NO_DATA );
    		}
    		  jsonObject.put("success",tag );
    		}
    	
    	return jsonObject.toString();
    }
    
  
}
