package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.dao.ProductHistoryMapper;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.entity.ProductHistoryExample;
import com.citi.portfoliomanager.service.IService.IProductHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by hkz on 2018/8/13.
 */
@Service
public class ProductHistoryService implements IProductHistoryService{

    @Autowired
    private ProductHistoryMapper productHistoryMapper;
    @Override
    public ProductHistory getProductHistory(Date generateDate, String name) {
        ProductHistoryExample productHistoryExample=new ProductHistoryExample();
        productHistoryExample.createCriteria().andGenerateDateEqualTo(generateDate).andNameEqualTo(name);
        if(productHistoryMapper.selectByExample(productHistoryExample).size()==0)
            return null;
        else {
            ProductHistory productHistory=productHistoryMapper.selectByExample(productHistoryExample).get(0);
            return productHistory;
        }
    }
}
