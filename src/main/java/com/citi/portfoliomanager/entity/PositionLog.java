package com.citi.portfoliomanager.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PositionLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position_log.exchange_log_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Integer exchangeLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position_log.position_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Integer positionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position_log.product_name
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position_log.quantity
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position_log.price
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pm_position_log.product_date
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    private Date productDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position_log.exchange_log_id
     *
     * @return the value of pm_position_log.exchange_log_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Integer getExchangeLogId() {
        return exchangeLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position_log.exchange_log_id
     *
     * @param exchangeLogId the value for pm_position_log.exchange_log_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setExchangeLogId(Integer exchangeLogId) {
        this.exchangeLogId = exchangeLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position_log.position_id
     *
     * @return the value of pm_position_log.position_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position_log.position_id
     *
     * @param positionId the value for pm_position_log.position_id
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position_log.product_name
     *
     * @return the value of pm_position_log.product_name
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position_log.product_name
     *
     * @param productName the value for pm_position_log.product_name
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position_log.quantity
     *
     * @return the value of pm_position_log.quantity
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position_log.quantity
     *
     * @param quantity the value for pm_position_log.quantity
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position_log.price
     *
     * @return the value of pm_position_log.price
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position_log.price
     *
     * @param price the value for pm_position_log.price
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_position_log.product_date
     *
     * @return the value of pm_position_log.product_date
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Date getProductDate() {
        return productDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_position_log.product_date
     *
     * @param productDate the value for pm_position_log.product_date
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }
}