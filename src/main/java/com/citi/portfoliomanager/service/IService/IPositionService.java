package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.Position;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IPositionService {
    //buy product
    boolean buyProduct(Integer portfolioId,Date today,String name,Integer quantity);

    //sell product
    boolean sellProduct(Integer portfolioId,Date today,String name,Integer quantity);

    //integration of buy and sell
    boolean processProduct(Integer portfolioId,Date today,String name,Integer quantity,Integer side);

    //listPositionByPortfolioIdAndProductName
    List<Position> listPositionByPortfolioIdAndProductName(Integer portfolioId,String productName);
    
    //listPositionByPortfolioIdAndProductName
   // List<Position> listPositionByPortfolioId(Integer portfolioId);

    //delete position
    boolean deletePosition(Integer positionId);

    //update position quantity
    boolean updatePositionQuantity(Integer positionId,Integer newQuantity);

    /**
     * positionHistory,Trade
     */
    //save log
    boolean insertTrade(Date buyDate, BigDecimal buyPrice,Date sellDate, BigDecimal sellPrice,Integer quantity,BigDecimal ratesOfReturn,String productName);
}
