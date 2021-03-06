package com.citi.portfoliomanager.service.IService;

import java.util.List;
import java.util.Map;

import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.Position;

public interface ICalculateRateService {
   public  double portfolioRateOfReturn(int portfolioId);  
   public List<Portfolio> portfolioRateOfReturn(List<Portfolio> protfolios); 
   public List<Portfolio> sortportfolioByRateOfReturn();
   boolean updatePortfolioHistory();
   public List<Position> listPositionByPortfolio(int portfolioId);
   
}
