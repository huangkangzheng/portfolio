package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.constant.DictEnum;
import com.citi.portfoliomanager.dao.PortfolioMapper;
import com.citi.portfoliomanager.dao.UserMapper;
import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.PortfolioExample;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.service.IService.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private PortfolioMapper portfolioMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean createPortfolio(User user, String name, Double initAsset, Integer strategy) {
        Portfolio portfolio=new Portfolio();
        BigDecimal bInitAsset=new BigDecimal(initAsset);
        portfolio.setInitialAsset(bInitAsset);
        portfolio.setCash(bInitAsset);
        portfolio.setStrategy(strategy);
        portfolio.setUserId(user.getUserId());
        portfolio.setName(name);
        portfolio.setStatus(DictEnum.STATUS_DEFAULT);
        try{
            if(portfolioMapper.insert(portfolio)==1){
                if(user.getCash().compareTo(bInitAsset)>=0){
                    user.setCash(user.getCash().subtract(bInitAsset));
                    if(userMapper.updateByPrimaryKey(user)==1)
                        return true;
                }
                return false;
            }
            return false;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public List<Portfolio> listPortfolioByUserId(Integer userId) {
        PortfolioExample portfolioExample=new PortfolioExample();
        portfolioExample.createCriteria().andUserIdEqualTo(userId);
        List<Portfolio> portfolioList=new ArrayList<Portfolio>();
        portfolioList=portfolioMapper.selectByExample(portfolioExample);
        return portfolioList;
    }

	@Override
	public boolean changeUserId(Integer portfolioId, Integer userId) {
		// TODO Auto-generated method stub
		
		Portfolio portfolio=portfolioMapper.selectByPrimaryKey(portfolioId);
		if(portfolio==null) {
			return false;
		}
		else {
		   portfolio.setUserId(userId);
		   if(portfolioMapper.updateByPrimaryKey(portfolio)==1) {
			   return true;
		   }else {
			   return false;
		   }
		}
	}
    
    
}
