package com.citi.portfoliomanager.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PositionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public PositionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
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
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
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

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Integer value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Integer value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Integer value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Integer value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Integer> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Integer> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdIsNull() {
            addCriterion("portfolio_id is null");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdIsNotNull() {
            addCriterion("portfolio_id is not null");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdEqualTo(Integer value) {
            addCriterion("portfolio_id =", value, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdNotEqualTo(Integer value) {
            addCriterion("portfolio_id <>", value, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdGreaterThan(Integer value) {
            addCriterion("portfolio_id >", value, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("portfolio_id >=", value, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdLessThan(Integer value) {
            addCriterion("portfolio_id <", value, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdLessThanOrEqualTo(Integer value) {
            addCriterion("portfolio_id <=", value, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdIn(List<Integer> values) {
            addCriterion("portfolio_id in", values, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdNotIn(List<Integer> values) {
            addCriterion("portfolio_id not in", values, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdBetween(Integer value1, Integer value2) {
            addCriterion("portfolio_id between", value1, value2, "portfolioId");
            return (Criteria) this;
        }

        public Criteria andPortfolioIdNotBetween(Integer value1, Integer value2) {
            addCriterion("portfolio_id not between", value1, value2, "portfolioId");
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

        public Criteria andProductDateIsNull() {
            addCriterion("product_date is null");
            return (Criteria) this;
        }

        public Criteria andProductDateIsNotNull() {
            addCriterion("product_date is not null");
            return (Criteria) this;
        }

        public Criteria andProductDateEqualTo(Date value) {
            addCriterionForJDBCDate("product_date =", value, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("product_date <>", value, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateGreaterThan(Date value) {
            addCriterionForJDBCDate("product_date >", value, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("product_date >=", value, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateLessThan(Date value) {
            addCriterionForJDBCDate("product_date <", value, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("product_date <=", value, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateIn(List<Date> values) {
            addCriterionForJDBCDate("product_date in", values, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("product_date not in", values, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("product_date between", value1, value2, "productDate");
            return (Criteria) this;
        }

        public Criteria andProductDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("product_date not between", value1, value2, "productDate");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_position
     *
     * @mbggenerated do_not_delete_during_merge Thu Aug 16 10:07:13 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_position
     *
     * @mbggenerated Thu Aug 16 10:07:13 CST 2018
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