package com.citi.portfoliomanager.service.IService;

import java.util.Date;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IPositionService {
    boolean buyProduct(Integer portfolioId,Date today,String name,Integer quantity);
    boolean sellProduct(Integer portfolioId,Date today,String name,Integer quantity);
}
