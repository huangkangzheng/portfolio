package com.citi.portfoliomanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IUserService;
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
    public User getUser(@RequestParam("username")String username){
        logger.info("param{}:username="+username);
        User user=userService.getUser(username);
        return user;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String Login(@RequestParam("username")String username,@RequestParam("password")String password){
        logger.info("param{}:username="+username);
        int result=userService.login(username, password);
        JSONObject jsonObject = new JSONObject();
        if(result<0) {
        	jsonObject.put("status", result);
        }else {
        	jsonObject.put("status", 0);
        	jsonObject.put("type", result);
        }
        return jsonObject.toString();
    }
}
