package com.citi.portfoliomanager.service;

import com.citi.portfoliomanager.constant.DictEnum;
import com.citi.portfoliomanager.dao.*;
import com.citi.portfoliomanager.entity.*;
import com.citi.portfoliomanager.service.IService.IPositionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
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
    @Autowired
    private TradeMapper tradeMapper;

    @Override
    @Transactional
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
        position.setBuyPrice(productHistory.getPrice());
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
    @Transactional
    public boolean sellProduct(Integer portfolioId, Date today, String productName, Integer quantity) {

        //select ProductHistory by today and name
        ProductHistoryExample productHistoryExample=new ProductHistoryExample();
        productHistoryExample.createCriteria().andGenerateDateEqualTo(today).andNameEqualTo(productName);
        List<ProductHistory> productHistoryList=productHistoryMapper.selectByExample(productHistoryExample);
        ProductHistory productHistory=productHistoryList.get(0);

        Portfolio portfolio=portfolioMapper.selectByPrimaryKey(portfolioId);

        //positionList sort by date desc (LIFO)
        List<Position> positionList=listPositionByPortfolioIdAndProductName(portfolioId,productName);

        //judge strategy, 0 means LIFO, 1 means FIFO
        if(portfolio.getStrategy().equals(DictEnum.Strategy.FIFO))
            Collections.reverse(positionList);


        //use strategy, change positions
        Integer currentQuantity=quantity;
        for(Position position:positionList){
            if(currentQuantity==0)
                break;
            //currentQuantity bigger than position'qty, then delete record
            BigDecimal rate=productHistory.getPrice().divide(position.getBuyPrice());
            rate=rate.subtract(new BigDecimal(1));
            if(currentQuantity>=position.getQuantity()){
                insertTrade(position.getProductDate(),position.getBuyPrice(),productHistory.getGenerateDate(),productHistory.getPrice(),position.getQuantity(),rate,position.getProductName());
                deletePosition(position.getPositionId());
                currentQuantity-=position.getQuantity();
            }
            //otherwise,write down corresponding position quantity
            else{
                insertTrade(position.getProductDate(),position.getBuyPrice(),productHistory.getGenerateDate(),productHistory.getPrice(),currentQuantity,rate,position.getProductName());
                Integer restQuantity=position.getQuantity()-currentQuantity;
                updatePositionQuantity(position.getPositionId(),restQuantity);
            }
        }

        //calculate order income
        BigDecimal income=productHistory.getPrice().multiply(new BigDecimal(quantity));

        //calculate portfolio's residueCash
        BigDecimal residueCash=portfolio.getCash().add(income);
        portfolio.setCash(residueCash);

        //update portfolio's residue cash
        if(portfolioMapper.updateByPrimaryKey(portfolio)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean processProduct(Integer portfolioId, Date today, String name, Integer quantity, Integer side) {
        boolean flag;
        if(side.equals(DictEnum.Side.BUY))
            flag=buyProduct(portfolioId,today,name,quantity);
        else
            flag=sellProduct(portfolioId,today,name,quantity);
        return flag;
    }

    /**
     * sorted positionList (By Date Desc)
     * @param portfolioId
     * @param productName
     * @return
     */
    @Override
    public List<Position> listPositionByPortfolioIdAndProductName(Integer portfolioId, String productName) {
        PositionExample positionExample=new PositionExample();
        positionExample.createCriteria().andPortfolioIdEqualTo(portfolioId).andProductNameEqualTo(productName);
        List<Position> positionList=positionMapper.selectByExample(positionExample);
        Collections.sort(positionList,new Comparator<Position>(){
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.getProductDate().compareTo(o2.getProductDate())>0)
                    return -1;
                else if(o1.getProductDate().compareTo(o2.getProductDate())==0)
                    return 0;
                else
                    return 1;
            }
        });
        return positionList;
    }

    @Override
    public boolean deletePosition(Integer positionId) {
        if(positionMapper.deleteByPrimaryKey(positionId)==1)
            return true;
        return false;
    }

    @Override
    public boolean updatePositionQuantity(Integer positionId, Integer newQuantity) {
        Position position=positionMapper.selectByPrimaryKey(positionId);
        position.setQuantity(newQuantity);
        if(positionMapper.updateByPrimaryKey(position)==1)
            return true;
        return false;
    }

    @Override
    public boolean insertTrade(Date buyDate, BigDecimal buyPrice, Date sellDate, BigDecimal sellPrice, Integer quantity, BigDecimal rateOfReturn, String productName) {
        Trade trade=new Trade();
        trade.setBuyDate(buyDate);
        trade.setBuyPrice(buyPrice);
        trade.setSellDate(sellDate);
        trade.setSellPrice(sellPrice);
        trade.setQuantity(quantity);
        trade.setProductName(productName);
        trade.setRateOfReturn(rateOfReturn);
        if(tradeMapper.insert(trade)==1)
            return true;
        return false;
    }
}
