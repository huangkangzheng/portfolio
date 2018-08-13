package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.User;

import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
public interface IPortfolioService {
    boolean createPortfolio(User user, String name, Double initAsset, Integer strategy);
    List<Portfolio> listPortfolioByUserId(Integer userId);
}
