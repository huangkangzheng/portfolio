package com.citi.portfoliomanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.entity.Position;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IPositionService;
import com.citi.portfoliomanager.service.IService.IProductHistoryService;
import com.citi.portfoliomanager.service.PositionService;
import javafx.geometry.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by hkz on 2018/8/14.
 */
@Controller
public class PositionController {
    private static final Logger logger= LogManager.getLogger(PositionController.class);

    @Autowired
    private IPositionService positionService;
    @Autowired
    private IProductHistoryService productHistoryService;

    @CrossOrigin
    @RequestMapping(value = "processProduct",method = RequestMethod.GET)
    @ResponseBody
    public String processProduct( @RequestParam(value = "portfolioId")Integer portfolioId,
                                 @RequestParam("productName")String productName,
                                  @RequestParam("quantity")Integer quantity,@RequestParam("side")Integer side){
        logger.info("processProduct>>>>>>param{}:"+portfolioId+" "+productName+" "+quantity+" "+side);
        JSONObject result=new JSONObject();
        if(positionService.processProduct(portfolioId, SystemDate.getSysDate(),productName,quantity,side)){
            result.put("success",true);
        }
        else result.put("success",false);
        return result.toString();
    }

    @CrossOrigin
    @RequestMapping(value = "getQuantityByPortfolioIdAndProductName",method = RequestMethod.GET)
    @ResponseBody
    public String getQuantityByPortfolioIdAndProductName( @RequestParam(value = "portfolioId")Integer portfolioId,
                                 @RequestParam("productName")String productName){
        logger.info("getQuantityByPortfolioIdAndProductName>>>>>>param{}:"+portfolioId+" "+productName);
        JSONObject result=new JSONObject();
        List<Position> positionList=positionService.listPositionByPortfolioIdAndProductName(portfolioId,productName);
        Integer totalQuantity=0;
        for(Position position:positionList)
            totalQuantity+=position.getQuantity();
        JSONObject data=new JSONObject();
        data.put("totalQTY",totalQuantity);
        ProductHistory productHistory=productHistoryService.getProductHistory(SystemDate.getSysDate(),productName);
        if(productHistory==null)
            result.put("success",false);
        else{
            result.put("success",true);
            data.put("todayPrice",productHistory.getPrice());
        }
        result.put("data",data);

        return result.toString();
    }
}
