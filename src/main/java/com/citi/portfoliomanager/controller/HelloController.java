package com.citi.portfoliomanager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hkz on 2017/4/23.
 */
@Controller
public class HelloController {

    private static final Logger logger= LogManager.getLogger(HelloController.class);

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        logger.info("进入index页面");
        return "index";
    }
}
