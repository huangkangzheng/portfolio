package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.Position;

import java.util.Date;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IPositionService {
    boolean buyProduct(Integer portfolioId,Date today,String name,Integer quantity);
    boolean sellProduct(Integer portfolioId,Date today,String name,Integer quantity);
    boolean processProduct(Integer portfolioId,Date today,String name,Integer quantity,Integer side);
    List<Position> listPositionByPortfolioIdAndProductName(Integer portfolioId,String productName);
    boolean deletePosition(Integer positionId);
    boolean updatePositionQuantity(Integer positionId,Integer newQuantity);
}
