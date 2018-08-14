package com.citi.portfolio.service;

import com.citi.portfolio.AppTests;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.service.IService.IPositionService;
import com.citi.portfoliomanager.service.PositionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

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
        else System.out.println("product history not exit");
        //Date today=
        //positionService.buyProduct(1,)
    }
}
