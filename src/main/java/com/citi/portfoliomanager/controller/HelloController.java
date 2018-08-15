package com.citi.portfoliomanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IUserService;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hkz on 2017/4/23.
 */
@Controller
public class HelloController {

    private static final Logger logger= LogManager.getLogger(HelloController.class);

    @Autowired
    private IUserService userService;
    
    @CrossOrigin
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
    	JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        return jsonObject.toString();
    }
    
    
    @CrossOrigin
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(HttpSession session){
    	User user=(User) session.getAttribute("userId");
        logger.info("getUser "+user);
        return user;
    }

    @CrossOrigin
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
        	jsonObject.put("status", 200);
            jsonObject.put("success", true);
        	jsonObject.put("type", user.getType());
        	jsonObject.put("userId", user.getUserId());
        	session.setAttribute("user", user);
        }
        return jsonObject.toString();
    }
    
    
    @CrossOrigin
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public String logOut(HttpSession session){
    	User user=(User) session.getAttribute("userId");
    	if(user!=null) {
    		logger.info("login out: "+user.getUsername());
    	}
        session.setAttribute("user", null);
        JSONObject jsonObject = new JSONObject();
      //  jsonObject.put("success", true);
        jsonObject.put("id", null);
        jsonObject.put("uername", null);
        jsonObject.put("type", null);
        return JSONObject.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue);
    }
}
