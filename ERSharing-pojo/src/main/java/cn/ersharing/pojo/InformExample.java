package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InformExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andInformIdIsNull() {
            addCriterion("inform_id is null");
            return (Criteria) this;
        }

        public Criteria andInformIdIsNotNull() {
            addCriterion("inform_id is not null");
            return (Criteria) this;
        }

        public Criteria andInformIdEqualTo(Integer value) {
            addCriterion("inform_id =", value, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdNotEqualTo(Integer value) {
            addCriterion("inform_id <>", value, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdGreaterThan(Integer value) {
            addCriterion("inform_id >", value, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("inform_id >=", value, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdLessThan(Integer value) {
            addCriterion("inform_id <", value, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdLessThanOrEqualTo(Integer value) {
            addCriterion("inform_id <=", value, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdIn(List<Integer> values) {
            addCriterion("inform_id in", values, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdNotIn(List<Integer> values) {
            addCriterion("inform_id not in", values, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdBetween(Integer value1, Integer value2) {
            addCriterion("inform_id between", value1, value2, "informId");
            return (Criteria) this;
        }

        public Criteria andInformIdNotBetween(Integer value1, Integer value2) {
            addCriterion("inform_id not between", value1, value2, "informId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidIsNull() {
            addCriterion("enterprise_followid is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidIsNotNull() {
            addCriterion("enterprise_followid is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidEqualTo(Integer value) {
            addCriterion("enterprise_followid =", value, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidNotEqualTo(Integer value) {
            addCriterion("enterprise_followid <>", value, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidGreaterThan(Integer value) {
            addCriterion("enterprise_followid >", value, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_followid >=", value, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidLessThan(Integer value) {
            addCriterion("enterprise_followid <", value, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_followid <=", value, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidIn(List<Integer> values) {
            addCriterion("enterprise_followid in", values, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidNotIn(List<Integer> values) {
            addCriterion("enterprise_followid not in", values, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_followid between", value1, value2, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseFollowidNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_followid not between", value1, value2, "enterpriseFollowid");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIsNull() {
            addCriterion("follow_time is null");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIsNotNull() {
            addCriterion("follow_time is not null");
            return (Criteria) this;
        }

        public Criteria andFollowTimeEqualTo(Date value) {
            addCriterion("follow_time =", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotEqualTo(Date value) {
            addCriterion("follow_time <>", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeGreaterThan(Date value) {
            addCriterion("follow_time >", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("follow_time >=", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeLessThan(Date value) {
            addCriterion("follow_time <", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeLessThanOrEqualTo(Date value) {
            addCriterion("follow_time <=", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIn(List<Date> values) {
            addCriterion("follow_time in", values, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotIn(List<Date> values) {
            addCriterion("follow_time not in", values, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeBetween(Date value1, Date value2) {
            addCriterion("follow_time between", value1, value2, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotBetween(Date value1, Date value2) {
            addCriterion("follow_time not between", value1, value2, "followTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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