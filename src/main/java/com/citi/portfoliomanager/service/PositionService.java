package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.dao.PortfolioMapper;
import com.citi.portfoliomanager.dao.PositionMapper;
import com.citi.portfoliomanager.dao.ProductHistoryMapper;
import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.Position;
import com.citi.portfoliomanager.entity.ProductHistory;
import com.citi.portfoliomanager.entity.ProductHistoryExample;
import com.citi.portfoliomanager.service.IService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hkz on 2018/8/13.
 */
@Service
public class PositionService implements IPositionService{

    @Autowired
    private ProductHistoryMapper productHistoryMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PortfolioMapper portfolioMapper;

    @Override
    public boolean buyProduct(Integer portfolioId, Date today, String productName, Integer quantity) {

        //select ProductHistory by today and name
        ProductHistoryExample productHistoryExample=new ProductHistoryExample();
        productHistoryExample.createCriteria().andGenerateDateEqualTo(today).andNameEqualTo(productName);
        List<ProductHistory> productHistoryList=productHistoryMapper.selectByExample(productHistoryExample);
        ProductHistory productHistory=productHistoryList.get(0);

        //insert a Position record
        Position position=new Position();
        position.setPortfolioId(portfolioId);
        position.setProductDate(today);
        position.setProductName(productName);
        position.setQuantity(quantity);
        //insert record
        if(positionMapper.insert(position)==1){
            //calculate order cost
            BigDecimal cost=productHistory.getPrice().multiply(new BigDecimal(quantity));
            Portfolio portfolio=portfolioMapper.selectByPrimaryKey(portfolioId);
            //calculate portfolio's residueCash
            BigDecimal residueCash=portfolio.getCash().subtract(cost);
            portfolio.setCash(residueCash);

            //bind transaction,update portfolio's residue cash
            if(portfolioMapper.updateByPrimaryKey(portfolio)==1){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean sellProduct(Integer portfolioId, Date today, String productName, Integer quantity) {

        //select ProductHistory by today and name
        ProductHistoryExample productHistoryExample=new ProductHistoryExample();
        productHistoryExample.createCriteria().andGenerateDateEqualTo(today).andNameEqualTo(productName);
        List<ProductHistory> productHistoryList=productHistoryMapper.selectByExample(productHistoryExample);
        ProductHistory productHistory=productHistoryList.get(0);

        //insert a Position record
        Position position=new Position();
        position.setPortfolioId(portfolioId);
        position.setProductDate(today);
        position.setProductName(productName);
        position.setQuantity(quantity);

        //calculate order income
        BigDecimal income=productHistory.getPrice().multiply(new BigDecimal(quantity));
        Portfolio portfolio=portfolioMapper.selectByPrimaryKey(portfolioId);
        //calculate portfolio's residueCash
        BigDecimal residueCash=portfolio.getCash().add(income);
        portfolio.setCash(residueCash);

        //update portfolio's residue cash
        if(portfolioMapper.updateByPrimaryKey(portfolio)==1){
            return true;
        }
        return false;
    }
}
