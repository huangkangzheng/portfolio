package com.citi.portfoliomanager.service.IService;

import java.util.List;
import java.util.Map;

import com.citi.portfoliomanager.entity.Portfolio;

public interface ICalculateRateService {
   public double portfolioRateOfReturn(int portfolioId);  
   public Map<Integer,Double> portfolioRateOfReturn();
   public List<Portfolio> sortportfolioByRateOfReturn();
   
}
