package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.ProductHistory;

import java.util.Date;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IProductHistoryService {
    ProductHistory getProductHistory(Date generateDate,String productName);

    List<ProductHistory> listProductHistory(String productName);
}
