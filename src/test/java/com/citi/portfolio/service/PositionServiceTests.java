package com.citi.portfolio.service;

import com.citi.portfolio.AppTests;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.entity.Position;
import com.citi.portfoliomanager.service.IService.IPositionService;
import com.citi.portfoliomanager.service.PositionService;
import com.citi.portfoliomanager.util.JSONUtil;
import javafx.geometry.Pos;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
public class PositionServiceTests extends AppTests {
    @Autowired
    private IPositionService positionService;

    @Test
    public void buyProduct() throws Exception {
        Date date= SystemDate.getSysDate();
        if(positionService.buyProduct(3,date,"Nikkei",100))
            System.out.println("success");
        //Date today=
        //positionService.buyProduct(1,)
    }

    @Test
    public void sellProduct() throws Exception {
        Date date= SystemDate.getSysDate();
        if(positionService.sellProduct(2,date,"AMZN",1500))
            System.out.println("success");
        //Date today=
        //positionService.buyProduct(1,)
    }

    @Test
    public void listPositionByPortfolioIdAndProductName() throws Exception {
        List<Position> positionList=positionService.listPositionByPortfolioIdAndProductName(2,"AMZN");
        System.out.println(JSONUtil.toJsonString(positionList));
        //Date today=
        //positionService.buyProduct(1,)
    }

}
