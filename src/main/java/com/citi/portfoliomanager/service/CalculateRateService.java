package com.citi.portfoliomanager.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.dao.PortfolioHistoryMapper;
import com.citi.portfoliomanager.dao.PortfolioMapper;
import com.citi.portfoliomanager.dao.PositionMapper;
import com.citi.portfoliomanager.dao.ProductHistoryMapper;
import com.citi.portfoliomanager.dao.UserMapper;
import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.PortfolioExample;
import com.citi.portfoliomanager.entity.PortfolioHistory;
import com.citi.portfoliomanager.entity.PortfolioHistoryExample;
import com.citi.portfoliomanager.entity.Position;
import com.citi.portfoliomanager.entity.PositionExample;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.entity.ProductHistoryExample;
import com.citi.portfoliomanager.service.IService.ICalculateRateService;

@Service
public class CalculateRateService implements ICalculateRateService{
	    @Autowired
	    private PortfolioMapper portfolioMapper;
	    @Autowired
	    private UserMapper userMapper;
	    @Autowired
	    private ProductHistoryMapper productHistoryMapper;
	    @Autowired
	    private PositionMapper positionMapper;
	    
	    @Override
	    public double portfolioRateOfReturn(int portfolioId) {
	    	return 0.0;
	    }
	    @Override
       public Map<Integer,Double> portfolioRateOfReturn() {
	    	return null;
	    }

	@Override
	public List<Portfolio> sortportfolioByRateOfReturn() {
		// TODO Auto-generated method stub
		PortfolioExample pe=new PortfolioExample();
		pe.createCriteria();
		List<Portfolio>portfolios=portfolioMapper.selectByExample(pe);
		PositionExample oe=new PositionExample();
		oe.createCriteria();
		List<Position> positions=positionMapper.selectByExample(oe);
		final Map<Integer,BigDecimal> rateMap=calPortfolioByRate(portfolios,calPosition(positions,buildProductHistoryMap()));
		Collections.sort(portfolios, new Comparator<Portfolio>() {

			@Override
			public int compare(Portfolio o1, Portfolio o2) {
				// TODO Auto-generated method stub
				BigDecimal bd2=rateMap.get(o1.getPortfolioId());
				BigDecimal bd1=rateMap.get(o2.getPortfolioId());
				return bd1.compareTo(bd2);
			}});
		return portfolios;
	}
	
	private Map<String,BigDecimal>buildProductHistoryMap(){
		Map<String,BigDecimal> map=new TreeMap<>();
		for(ProductHistory ph:productHistoryMapper.selectEachLeastRencently(SystemDate.getSysDate())) {
			map.put(ph.getName(), ph.getPrice());
		}
		return map;
	}
	
	private Map<Integer,BigDecimal>calPosition(List<Position> positions,Map<String,BigDecimal> productHistory){
		Map<Integer,BigDecimal> result=new TreeMap<Integer, BigDecimal>();
	    for(Position pos:positions) {
	    	BigDecimal res=result.getOrDefault(pos.getPortfolioId(),new BigDecimal(0));
	    	BigDecimal price=productHistory.getOrDefault(pos.getProductName(),new BigDecimal(0));
	    	res=res.add(price.multiply(new BigDecimal(pos.getQuantity())));
	    	result.put(pos.getPortfolioId(), res);
	    }
	    return result;
	}
	
	private Map<Integer,BigDecimal>calPortfolioByRate(List<Portfolio>portfolios,Map<Integer,BigDecimal> positionTotal){
		Map<Integer,BigDecimal>res=new TreeMap<>();
		for(Portfolio port:portfolios) {
			BigDecimal bd=port.getCash();
			if(positionTotal.get(port.getPortfolioId())!=null){
			     bd=bd.add(positionTotal.get(port.getPortfolioId()));
			}
			bd=bd.divide(port.getInitialAsset());
			res.put(port.getPortfolioId(), bd);
		}
		return res;
	}

	
}
