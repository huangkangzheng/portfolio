package com.citi.portfoliomanager.dao;

import com.citi.portfoliomanager.entity.Portfolio;
import com.citi.portfoliomanager.entity.PortfolioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PortfolioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int countByExample(PortfolioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int deleteByExample(PortfolioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int deleteByPrimaryKey(Integer portfolioId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int insert(Portfolio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int insertSelective(Portfolio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    List<Portfolio> selectByExample(PortfolioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    Portfolio selectByPrimaryKey(Integer portfolioId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") Portfolio record, @Param("example") PortfolioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByExample(@Param("record") Portfolio record, @Param("example") PortfolioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByPrimaryKeySelective(Portfolio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByPrimaryKey(Portfolio record);
}