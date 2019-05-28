package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdIsNull() {
            addCriterion("sharing_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdIsNotNull() {
            addCriterion("sharing_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdEqualTo(Integer value) {
            addCriterion("sharing_enterprise_id =", value, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("sharing_enterprise_id <>", value, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdGreaterThan(Integer value) {
            addCriterion("sharing_enterprise_id >", value, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharing_enterprise_id >=", value, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdLessThan(Integer value) {
            addCriterion("sharing_enterprise_id <", value, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("sharing_enterprise_id <=", value, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdIn(List<Integer> values) {
            addCriterion("sharing_enterprise_id in", values, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("sharing_enterprise_id not in", values, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("sharing_enterprise_id between", value1, value2, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andSharingEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sharing_enterprise_id not between", value1, value2, "sharingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdIsNull() {
            addCriterion("accept_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdIsNotNull() {
            addCriterion("accept_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdEqualTo(Integer value) {
            addCriterion("accept_enterprise_id =", value, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("accept_enterprise_id <>", value, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdGreaterThan(Integer value) {
            addCriterion("accept_enterprise_id >", value, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("accept_enterprise_id >=", value, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdLessThan(Integer value) {
            addCriterion("accept_enterprise_id <", value, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("accept_enterprise_id <=", value, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdIn(List<Integer> values) {
            addCriterion("accept_enterprise_id in", values, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("accept_enterprise_id not in", values, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("accept_enterprise_id between", value1, value2, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andAcceptEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("accept_enterprise_id not between", value1, value2, "acceptEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeIsNull() {
            addCriterion("record_tradeTime is null");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeIsNotNull() {
            addCriterion("record_tradeTime is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeEqualTo(Date value) {
            addCriterion("record_tradeTime =", value, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeNotEqualTo(Date value) {
            addCriterion("record_tradeTime <>", value, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeGreaterThan(Date value) {
            addCriterion("record_tradeTime >", value, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_tradeTime >=", value, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeLessThan(Date value) {
            addCriterion("record_tradeTime <", value, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeLessThanOrEqualTo(Date value) {
            addCriterion("record_tradeTime <=", value, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeIn(List<Date> values) {
            addCriterion("record_tradeTime in", values, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeNotIn(List<Date> values) {
            addCriterion("record_tradeTime not in", values, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeBetween(Date value1, Date value2) {
            addCriterion("record_tradeTime between", value1, value2, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordTradetimeNotBetween(Date value1, Date value2) {
            addCriterion("record_tradeTime not between", value1, value2, "recordTradetime");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentIsNull() {
            addCriterion("record_payment is null");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentIsNotNull() {
            addCriterion("record_payment is not null");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentEqualTo(Float value) {
            addCriterion("record_payment =", value, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentNotEqualTo(Float value) {
            addCriterion("record_payment <>", value, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentGreaterThan(Float value) {
            addCriterion("record_payment >", value, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentGreaterThanOrEqualTo(Float value) {
            addCriterion("record_payment >=", value, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentLessThan(Float value) {
            addCriterion("record_payment <", value, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentLessThanOrEqualTo(Float value) {
            addCriterion("record_payment <=", value, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentIn(List<Float> values) {
            addCriterion("record_payment in", values, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentNotIn(List<Float> values) {
            addCriterion("record_payment not in", values, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentBetween(Float value1, Float value2) {
            addCriterion("record_payment between", value1, value2, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andRecordPaymentNotBetween(Float value1, Float value2) {
            addCriterion("record_payment not between", value1, value2, "recordPayment");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIsNull() {
            addCriterion("resources_id is null");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIsNotNull() {
            addCriterion("resources_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesIdEqualTo(Integer value) {
            addCriterion("resources_id =", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotEqualTo(Integer value) {
            addCriterion("resources_id <>", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdGreaterThan(Integer value) {
            addCriterion("resources_id >", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resources_id >=", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLessThan(Integer value) {
            addCriterion("resources_id <", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLessThanOrEqualTo(Integer value) {
            addCriterion("resources_id <=", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIn(List<Integer> values) {
            addCriterion("resources_id in", values, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotIn(List<Integer> values) {
            addCriterion("resources_id not in", values, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdBetween(Integer value1, Integer value2) {
            addCriterion("resources_id between", value1, value2, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resources_id not between", value1, value2, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberIsNull() {
            addCriterion("record_resources_number is null");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberIsNotNull() {
            addCriterion("record_resources_number is not null");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberEqualTo(Integer value) {
            addCriterion("record_resources_number =", value, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberNotEqualTo(Integer value) {
            addCriterion("record_resources_number <>", value, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberGreaterThan(Integer value) {
            addCriterion("record_resources_number >", value, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_resources_number >=", value, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberLessThan(Integer value) {
            addCriterion("record_resources_number <", value, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberLessThanOrEqualTo(Integer value) {
            addCriterion("record_resources_number <=", value, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberIn(List<Integer> values) {
            addCriterion("record_resources_number in", values, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberNotIn(List<Integer> values) {
            addCriterion("record_resources_number not in", values, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberBetween(Integer value1, Integer value2) {
            addCriterion("record_resources_number between", value1, value2, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourcesNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("record_resources_number not between", value1, value2, "recordResourcesNumber");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeIsNull() {
            addCriterion("record_resource_operateType is null");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeIsNotNull() {
            addCriterion("record_resource_operateType is not null");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeEqualTo(Integer value) {
            addCriterion("record_resource_operateType =", value, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeNotEqualTo(Integer value) {
            addCriterion("record_resource_operateType <>", value, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeGreaterThan(Integer value) {
            addCriterion("record_resource_operateType >", value, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_resource_operateType >=", value, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeLessThan(Integer value) {
            addCriterion("record_resource_operateType <", value, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeLessThanOrEqualTo(Integer value) {
            addCriterion("record_resource_operateType <=", value, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeIn(List<Integer> values) {
            addCriterion("record_resource_operateType in", values, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeNotIn(List<Integer> values) {
            addCriterion("record_resource_operateType not in", values, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeBetween(Integer value1, Integer value2) {
            addCriterion("record_resource_operateType between", value1, value2, "recordResourceOperatetype");
            return (Criteria) this;
        }

        public Criteria andRecordResourceOperatetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("record_resource_operateType not between", value1, value2, "recordResourceOperatetype");
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