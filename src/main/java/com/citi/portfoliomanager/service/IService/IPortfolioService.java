package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.PortfolioHistory;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IPortfolioService {
    //create a new portfolio
    boolean createPortfolio(User user, String name, Double initAsset, Integer strategy);

    //get portfolio list by userId
    List<Portfolio> listPortfolioByUserId(Integer userId);

    //update portfolio's owner(by userId)
    boolean changeUserId(Integer portfolioId, Integer userId);

    boolean updataPortfolio(Integer portfolioId,String name);

    //get portfolio By portfolioId
    Portfolio getPortfolioById(Integer portfolioId);

    Map<String,Object> queryRate(Integer portfolioId, String productName);
    
    List<Portfolio>searchPortfolio(Integer userId,String productName);
    
  
}
