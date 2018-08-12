package com.citi.portfoliomanager.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PortfolioExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public PortfolioExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
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
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIntialAssetIsNull() {
            addCriterion("intial_asset is null");
            return (Criteria) this;
        }

        public Criteria andIntialAssetIsNotNull() {
            addCriterion("intial_asset is not null");
            return (Criteria) this;
        }

        public Criteria andIntialAssetEqualTo(BigDecimal value) {
            addCriterion("intial_asset =", value, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetNotEqualTo(BigDecimal value) {
            addCriterion("intial_asset <>", value, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetGreaterThan(BigDecimal value) {
            addCriterion("intial_asset >", value, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("intial_asset >=", value, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetLessThan(BigDecimal value) {
            addCriterion("intial_asset <", value, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("intial_asset <=", value, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetIn(List<BigDecimal> values) {
            addCriterion("intial_asset in", values, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetNotIn(List<BigDecimal> values) {
            addCriterion("intial_asset not in", values, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("intial_asset between", value1, value2, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andIntialAssetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("intial_asset not between", value1, value2, "intialAsset");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCashIsNull() {
            addCriterion("cash is null");
            return (Criteria) this;
        }

        public Criteria andCashIsNotNull() {
            addCriterion("cash is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqualTo(BigDecimal value) {
            addCriterion("cash =", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotEqualTo(BigDecimal value) {
            addCriterion("cash <>", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThan(BigDecimal value) {
            addCriterion("cash >", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash >=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThan(BigDecimal value) {
            addCriterion("cash <", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash <=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashIn(List<BigDecimal> values) {
            addCriterion("cash in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotIn(List<BigDecimal> values) {
            addCriterion("cash not in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash not between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNull() {
            addCriterion("strategy is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNotNull() {
            addCriterion("strategy is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyEqualTo(Integer value) {
            addCriterion("strategy =", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotEqualTo(Integer value) {
            addCriterion("strategy <>", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThan(Integer value) {
            addCriterion("strategy >", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThanOrEqualTo(Integer value) {
            addCriterion("strategy >=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThan(Integer value) {
            addCriterion("strategy <", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThanOrEqualTo(Integer value) {
            addCriterion("strategy <=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyIn(List<Integer> values) {
            addCriterion("strategy in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotIn(List<Integer> values) {
            addCriterion("strategy not in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyBetween(Integer value1, Integer value2) {
            addCriterion("strategy between", value1, value2, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotBetween(Integer value1, Integer value2) {
            addCriterion("strategy not between", value1, value2, "strategy");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_portfolio
     *
     * @mbggenerated do_not_delete_during_merge Sun Aug 12 20:46:29 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pm_portfolio
     *
     * @mbggenerated Sun Aug 12 20:46:29 CST 2018
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