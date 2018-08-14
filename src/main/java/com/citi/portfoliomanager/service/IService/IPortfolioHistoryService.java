package com.citi.portfoliomanager.service.IService;

import java.util.List;

import com.citi.portfoliomanager.entity.PortfolioHistory;

public interface IPortfolioHistoryService {
      List<PortfolioHistory> listPortfolioHistory(int portfolioId);
}
