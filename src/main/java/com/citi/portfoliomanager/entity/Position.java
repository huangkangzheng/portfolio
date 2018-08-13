package com.citi.portfoliomanager.entity;

import java.util.Date;

public class Position {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position.product_profolio_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Integer productProfolioId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position.portfolio_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Integer portfolioId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position.product_name
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position.product_date
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Date productDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position.quantity
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Integer quantity;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position.product_profolio_id
     *
     * @return the value of pm_position.product_profolio_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Integer getProductProfolioId() {
        return productProfolioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position.product_profolio_id
     *
     * @param productProfolioId the value for pm_position.product_profolio_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setProductProfolioId(Integer productProfolioId) {
        this.productProfolioId = productProfolioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position.portfolio_id
     *
     * @return the value of pm_position.portfolio_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Integer getPortfolioId() {
        return portfolioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position.portfolio_id
     *
     * @param portfolioId the value for pm_position.portfolio_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position.product_name
     *
     * @return the value of pm_position.product_name
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position.product_name
     *
     * @param productName the value for pm_position.product_name
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position.product_date
     *
     * @return the value of pm_position.product_date
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Date getProductDate() {
        return productDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position.product_date
     *
     * @param productDate the value for pm_position.product_date
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position.quantity
     *
     * @return the value of pm_position.quantity
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position.quantity
     *
     * @param quantity the value for pm_position.quantity
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}