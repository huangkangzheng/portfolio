package com.citi.portfoliomanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IUserService;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hkz on 2017/4/23.
 */
@Controller
public class HelloController {

    private static final Logger logger= LogManager.getLogger(HelloController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        logger.info("进入index页面");
        return "index";
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(HttpSession session){
    	Integer userId=(Integer) session.getAttribute("userId");
        logger.info("getUser :username="+userId);
        if(userId==null) {
        	return null;
        }
        User user=userService.getUser(userId);
        return user;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String Login(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session){
        logger.info("lgoin :username="+username);
        User user=userService.login(username, password);
        int result=user.getUserId();
        JSONObject jsonObject = new JSONObject();
        if(result<0) {
        	jsonObject.put("status", result);
            jsonObject.put("success",false);
        }else {
        	jsonObject.put("status", 0);
            jsonObject.put("success", true);
        	jsonObject.put("type", user.getType());
        	jsonObject.put("userId", user.getUserId());
        	session.setAttribute("userId", user.getUserId());
        }
        return jsonObject.toString();
    }
}
