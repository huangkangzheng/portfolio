package com.citi.portfoliomanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.portfoliomanager.dao.PortfolioHistoryMapper;
import com.citi.portfoliomanager.entity.PortfolioHistory;
import com.citi.portfoliomanager.entity.PortfolioHistoryExample;
import com.citi.portfoliomanager.service.IService.IPortfolioHistoryService;
@Service
public class PortfolioHistoryService implements IPortfolioHistoryService{
    
	 @Autowired
	    private PortfolioHistoryMapper portfolioHistoryMapper;
	
	@Override
	public List<PortfolioHistory> listPortfolioHistory(int portfolioId) {
		// TODO Auto-generated method stub
		PortfolioHistoryExample phe=new PortfolioHistoryExample();
		phe.createCriteria().andPortfolioIdEqualTo(portfolioId);
		phe.setOrderByClause("cal_date desc");
		return portfolioHistoryMapper.selectByExample(phe);
	}

}
