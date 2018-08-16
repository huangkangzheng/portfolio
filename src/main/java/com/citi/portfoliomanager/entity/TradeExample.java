package com.citi.portfoliomanager.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TradeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public TradeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTradeIdIsNull() {
            addCriterion("trade_id is null");
            return (Criteria) this;
        }

        public Criteria andTradeIdIsNotNull() {
            addCriterion("trade_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradeIdEqualTo(Integer value) {
            addCriterion("trade_id =", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotEqualTo(Integer value) {
            addCriterion("trade_id <>", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdGreaterThan(Integer value) {
            addCriterion("trade_id >", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_id >=", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLessThan(Integer value) {
            addCriterion("trade_id <", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("trade_id <=", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdIn(List<Integer> values) {
            addCriterion("trade_id in", values, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotIn(List<Integer> values) {
            addCriterion("trade_id not in", values, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdBetween(Integer value1, Integer value2) {
            addCriterion("trade_id between", value1, value2, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_id not between", value1, value2, "tradeId");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNull() {
            addCriterion("buy_date is null");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNotNull() {
            addCriterion("buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuyDateEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date =", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date <>", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("buy_date >", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date >=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThan(Date value) {
            addCriterionForJDBCDate("buy_date <", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date <=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateIn(List<Date> values) {
            addCriterionForJDBCDate("buy_date in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("buy_date not in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buy_date between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buy_date not between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("buy_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(BigDecimal value) {
            addCriterion("buy_price =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(BigDecimal value) {
            addCriterion("buy_price <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(BigDecimal value) {
            addCriterion("buy_price >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_price >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(BigDecimal value) {
            addCriterion("buy_price <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_price <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<BigDecimal> values) {
            addCriterion("buy_price in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<BigDecimal> values) {
            addCriterion("buy_price not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_price between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_price not between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andSellDateIsNull() {
            addCriterion("sell_date is null");
            return (Criteria) this;
        }

        public Criteria andSellDateIsNotNull() {
            addCriterion("sell_date is not null");
            return (Criteria) this;
        }

        public Criteria andSellDateEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date =", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date <>", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sell_date >", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date >=", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateLessThan(Date value) {
            addCriterionForJDBCDate("sell_date <", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sell_date <=", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateIn(List<Date> values) {
            addCriterionForJDBCDate("sell_date in", values, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sell_date not in", values, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sell_date between", value1, value2, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sell_date not between", value1, value2, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sell_price is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(BigDecimal value) {
            addCriterion("sell_price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("sell_price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(BigDecimal value) {
            addCriterion("sell_price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(BigDecimal value) {
            addCriterion("sell_price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<BigDecimal> values) {
            addCriterion("sell_price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("sell_price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnIsNull() {
            addCriterion("rate_of_return is null");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnIsNotNull() {
            addCriterion("rate_of_return is not null");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnEqualTo(BigDecimal value) {
            addCriterion("rate_of_return =", value, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnNotEqualTo(BigDecimal value) {
            addCriterion("rate_of_return <>", value, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnGreaterThan(BigDecimal value) {
            addCriterion("rate_of_return >", value, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_of_return >=", value, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnLessThan(BigDecimal value) {
            addCriterion("rate_of_return <", value, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_of_return <=", value, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnIn(List<BigDecimal> values) {
            addCriterion("rate_of_return in", values, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnNotIn(List<BigDecimal> values) {
            addCriterion("rate_of_return not in", values, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_of_return between", value1, value2, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andRateOfReturnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_of_return not between", value1, value2, "rateOfReturn");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andPortfolioidIsNull() {
            addCriterion("portfolioId is null");
            return (Criteria) this;
        }

        public Criteria andPortfolioidIsNotNull() {
            addCriterion("portfolioId is not null");
            return (Criteria) this;
        }

        public Criteria andPortfolioidEqualTo(String value) {
            addCriterion("portfolioId =", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidNotEqualTo(String value) {
            addCriterion("portfolioId <>", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidGreaterThan(String value) {
            addCriterion("portfolioId >", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidGreaterThanOrEqualTo(String value) {
            addCriterion("portfolioId >=", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidLessThan(String value) {
            addCriterion("portfolioId <", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidLessThanOrEqualTo(String value) {
            addCriterion("portfolioId <=", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidLike(String value) {
            addCriterion("portfolioId like", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidNotLike(String value) {
            addCriterion("portfolioId not like", value, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidIn(List<String> values) {
            addCriterion("portfolioId in", values, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidNotIn(List<String> values) {
            addCriterion("portfolioId not in", values, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidBetween(String value1, String value2) {
            addCriterion("portfolioId between", value1, value2, "portfolioid");
            return (Criteria) this;
        }

        public Criteria andPortfolioidNotBetween(String value1, String value2) {
            addCriterion("portfolioId not between", value1, value2, "portfolioid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_trade
     *
     * @mbggenerated do_not_delete_during_merge Thu Aug 16 10:08:33 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_trade
     *
     * @mbggenerated Thu Aug 16 10:08:33 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}