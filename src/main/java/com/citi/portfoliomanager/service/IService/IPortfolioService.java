package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.User;

import java.util.List;

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

    //get portfolio By portfolioId
    Portfolio getPortfolioById(Integer portfolioId);
}
