package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.constant.DictEnum;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.dao.ProductHistoryMapper;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.entity.ProductHistoryExample;
import com.citi.portfoliomanager.service.IService.IProductHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<ProductHistory> listProductHistory(String productName) {
        List<ProductHistory> productHistoryList=new ArrayList<ProductHistory>();
        Date today= SystemDate.getSysDate();
        for(int i = DictEnum.DATA_LIST_NUM; i>=1; i--) {
            Date begin = new Date(today.getTime() - DictEnum.EACH_DAY * i);
            ProductHistoryExample productHistoryExample=new ProductHistoryExample();
            productHistoryExample.clear();
            productHistoryExample.createCriteria().andGenerateDateEqualTo(begin).andNameEqualTo(productName);
            List<ProductHistory> temp2=productHistoryMapper.selectByExample(productHistoryExample);
            if(temp2.size()==0){
                productHistoryList.add(null);
            }
            else{
                productHistoryList.add(temp2.get(0));
            }
        }
        return productHistoryList;
    }
}
