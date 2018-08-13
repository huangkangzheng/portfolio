package com.citi.portfoliomanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IPortfolioService;
import com.citi.portfoliomanager.service.PortfolioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sound.sampled.Port;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
@Controller
public class PortfolioController {
    private static final Logger logger= LogManager.getLogger(PortfolioController.class);

    @Autowired
    private IPortfolioService portfolioService;

    @CrossOrigin
    @RequestMapping(value = "createPortfolio",method = RequestMethod.GET)
    @ResponseBody
    public String createPortfolio(HttpSession session,@RequestParam(value = "name")String name, @RequestParam("initAsset")String initAssetString,
                                  @RequestParam("strategy")Integer strategy){
        User user=(User) session.getAttribute("user");
        Double initAsset=Double.parseDouble(initAssetString);
        logger.info("createPortfolio>>>>> param={}"+user.getUserId()+" "+name+" "+initAsset+" "+strategy);
        JSONObject result=new JSONObject();
        if(portfolioService.createPortfolio(user,name,initAsset,strategy)){
            session.setAttribute("user", user);
            result.put("success",true);
            JSONObject jsonObject2=new JSONObject();
            jsonObject2.put("cash",user.getCash().doubleValue());
            result.put("data",jsonObject2);
        }
        else{
            result.put("success",false);
        }
        return result.toString();
    }

    @CrossOrigin
    @RequestMapping(value = "listPortfolioByUserId",method = RequestMethod.GET)
    @ResponseBody
    public String createPortfolio(HttpSession session){
        User user=(User) session.getAttribute("user");
        logger.info("listPortfolioByUserId>>>>> param={}"+user.getUserId());
        JSONObject result=new JSONObject();
        List<Portfolio> portfolioList=portfolioService.listPortfolioByUserId(user.getUserId());
        result.put("success",true);
        result.put("data",portfolioList);
        return result.toString();
    }


}
