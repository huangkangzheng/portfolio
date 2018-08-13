package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.ProductHistory;

import java.util.Date;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IProductHistoryService {
    ProductHistory getProductHistory(Date generateDate,String productName);
}
