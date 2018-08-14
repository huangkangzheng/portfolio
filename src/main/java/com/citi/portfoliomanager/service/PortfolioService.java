package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.constant.DictEnum;
import com.citi.portfoliomanager.constant.SystemDate;
import com.citi.portfoliomanager.dao.PortfolioHistoryMapper;
import com.citi.portfoliomanager.dao.PortfolioMapper;
import com.citi.portfoliomanager.dao.ProductHistoryMapper;
import com.citi.portfoliomanager.dao.UserMapper;
import com.citi.portfoliomanager.entity.*;
import com.citi.portfoliomanager.service.IService.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by hkz on 2018/8/13.
 */
@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private PortfolioMapper portfolioMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PortfolioHistoryMapper portfolioHistoryMapper;
    @Autowired
    private ProductHistoryMapper productHistoryMapper;

    @Override
    @Transactional
    public boolean createPortfolio(User user, String name, Double initAsset, Integer strategy) {
        //setter
        Portfolio portfolio=new Portfolio();
        BigDecimal bInitAsset=new BigDecimal(initAsset);
        portfolio.setInitialAsset(bInitAsset);
        portfolio.setCash(bInitAsset);
        portfolio.setStrategy(strategy);
        portfolio.setUserId(user.getUserId());
        portfolio.setName(name);
        portfolio.setStatus(DictEnum.STATUS_DEFAULT);
        try{
            //insert a portfolio into database
            if(portfolioMapper.insert(portfolio)==1){
                //only user's cash bigger than new portfolio's initAsset can be created
                if(user.getCash().compareTo(bInitAsset)>=0){
                    //bind transaction,update user's residue cash
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
        //user Mapper query result
        List<Portfolio> portfolioList=new ArrayList<Portfolio>();
        portfolioList=portfolioMapper.selectByExample(portfolioExample);
        return portfolioList;
    }

    @Override
    public Portfolio getPortfolioById(Integer portfolioId) {
        Portfolio portfolio=portfolioMapper.selectByPrimaryKey(portfolioId);
        return portfolio;
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

    @Override
    public Map<String, Object> queryRate(Integer portfolioId, String productName) {
        Map<String,Object> result=new HashMap<String,Object>();
        Date today= SystemDate.getSysDate();
        List<PortfolioHistory> portfolioHistoryList=new ArrayList<PortfolioHistory>();
        List<ProductHistory> productHistoryList=new ArrayList<ProductHistory>();
        for(int i=DictEnum.DATA_LIST_NUM;i>=1;i--){
            Date begin=new Date(today.getTime()-DictEnum.EACH_DAY*i);
            PortfolioHistoryExample portfolioHistoryExample=new PortfolioHistoryExample();
            portfolioHistoryExample.clear();
            portfolioHistoryExample.createCriteria().andCalDateEqualTo(begin).andPortfolioIdEqualTo(portfolioId);
            List<PortfolioHistory> temp=portfolioHistoryMapper.selectByExample(portfolioHistoryExample);
            if(temp.size()==0){
                portfolioHistoryList.add(null);
            }
            else
                portfolioHistoryList.add(temp.get(0));
            ProductHistoryExample productHistoryExample=new ProductHistoryExample();
            portfolioHistoryExample.clear();
            productHistoryExample.createCriteria().andGenerateDateEqualTo(begin).andNameEqualTo(productName);
            List<ProductHistory> temp2=productHistoryMapper.selectByExample(productHistoryExample);
            if(temp2.size()==0)
                productHistoryList.add(null);
            else
                productHistoryList.add(temp2.get(0));
        }
        result.put("portfolioList",portfolioHistoryList);
        result.put("productList",productHistoryList);


        /*Collections.sort(portfolioHistoryList, new Comparator<PortfolioHistory>() {
            @Override
            public int compare(PortfolioHistory o1, PortfolioHistory o2) {
                return o1.getCalDate().compareTo(o2.getCalDate());
            }
        });*/
        return result;
    }

}
