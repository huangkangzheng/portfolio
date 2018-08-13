package com.citi.portfoliomanager.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PortfolioHistoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public PortfolioHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
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
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
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

        public Criteria andPortfolioHistoryIdIsNull() {
            addCriterion("portfolio_history_id is null");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdIsNotNull() {
            addCriterion("portfolio_history_id is not null");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdEqualTo(Integer value) {
            addCriterion("portfolio_history_id =", value, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdNotEqualTo(Integer value) {
            addCriterion("portfolio_history_id <>", value, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdGreaterThan(Integer value) {
            addCriterion("portfolio_history_id >", value, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("portfolio_history_id >=", value, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdLessThan(Integer value) {
            addCriterion("portfolio_history_id <", value, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("portfolio_history_id <=", value, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdIn(List<Integer> values) {
            addCriterion("portfolio_history_id in", values, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdNotIn(List<Integer> values) {
            addCriterion("portfolio_history_id not in", values, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdBetween(Integer value1, Integer value2) {
            addCriterion("portfolio_history_id between", value1, value2, "portfolioHistoryId");
            return (Criteria) this;
        }

        public Criteria andPortfolioHistoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("portfolio_history_id not between", value1, value2, "portfolioHistoryId");
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

        public Criteria andCalDateIsNull() {
            addCriterion("cal_date is null");
            return (Criteria) this;
        }

        public Criteria andCalDateIsNotNull() {
            addCriterion("cal_date is not null");
            return (Criteria) this;
        }

        public Criteria andCalDateEqualTo(Date value) {
            addCriterionForJDBCDate("cal_date =", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("cal_date <>", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateGreaterThan(Date value) {
            addCriterionForJDBCDate("cal_date >", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cal_date >=", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateLessThan(Date value) {
            addCriterionForJDBCDate("cal_date <", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cal_date <=", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateIn(List<Date> values) {
            addCriterionForJDBCDate("cal_date in", values, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("cal_date not in", values, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cal_date between", value1, value2, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cal_date not between", value1, value2, "calDate");
            return (Criteria) this;
        }

        public Criteria andTotalAssetIsNull() {
            addCriterion("total_asset is null");
            return (Criteria) this;
        }

        public Criteria andTotalAssetIsNotNull() {
            addCriterion("total_asset is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAssetEqualTo(BigDecimal value) {
            addCriterion("total_asset =", value, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetNotEqualTo(BigDecimal value) {
            addCriterion("total_asset <>", value, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetGreaterThan(BigDecimal value) {
            addCriterion("total_asset >", value, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_asset >=", value, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetLessThan(BigDecimal value) {
            addCriterion("total_asset <", value, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_asset <=", value, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetIn(List<BigDecimal> values) {
            addCriterion("total_asset in", values, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetNotIn(List<BigDecimal> values) {
            addCriterion("total_asset not in", values, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_asset between", value1, value2, "totalAsset");
            return (Criteria) this;
        }

        public Criteria andTotalAssetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_asset not between", value1, value2, "totalAsset");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 13 12:02:45 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_portfolio_history
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
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