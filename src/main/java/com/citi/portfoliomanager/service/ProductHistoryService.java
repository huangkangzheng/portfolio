package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.service.IService.IProductHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by hkz on 2018/8/13.
 */
@Service
public class ProductHistoryService implements IProductHistoryService{

    @Override
    public ProductHistory getProductHistory(Date generateDate, String name) {
        return null;
    }
}
