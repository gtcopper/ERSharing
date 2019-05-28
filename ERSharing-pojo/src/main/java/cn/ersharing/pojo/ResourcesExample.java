package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourcesExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourcesExample() {
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

        public Criteria andResourcesCategoryIdIsNull() {
            addCriterion("resources_category_id is null");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdIsNotNull() {
            addCriterion("resources_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdEqualTo(Integer value) {
            addCriterion("resources_category_id =", value, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdNotEqualTo(Integer value) {
            addCriterion("resources_category_id <>", value, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdGreaterThan(Integer value) {
            addCriterion("resources_category_id >", value, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resources_category_id >=", value, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdLessThan(Integer value) {
            addCriterion("resources_category_id <", value, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("resources_category_id <=", value, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdIn(List<Integer> values) {
            addCriterion("resources_category_id in", values, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdNotIn(List<Integer> values) {
            addCriterion("resources_category_id not in", values, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("resources_category_id between", value1, value2, "resourcesCategoryId");
            return (Criteria) this;
        }

        public Criteria andResourcesCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resources_category_id not between", value1, value2, "resourcesCategoryId");
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

        public Criteria andEnterpriseCityIsNull() {
            addCriterion("enterprise_city is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityIsNotNull() {
            addCriterion("enterprise_city is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityEqualTo(String value) {
            addCriterion("enterprise_city =", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotEqualTo(String value) {
            addCriterion("enterprise_city <>", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityGreaterThan(String value) {
            addCriterion("enterprise_city >", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_city >=", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityLessThan(String value) {
            addCriterion("enterprise_city <", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityLessThanOrEqualTo(String value) {
            addCriterion("enterprise_city <=", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityLike(String value) {
            addCriterion("enterprise_city like", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotLike(String value) {
            addCriterion("enterprise_city not like", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityIn(List<String> values) {
            addCriterion("enterprise_city in", values, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotIn(List<String> values) {
            addCriterion("enterprise_city not in", values, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityBetween(String value1, String value2) {
            addCriterion("enterprise_city between", value1, value2, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotBetween(String value1, String value2) {
            addCriterion("enterprise_city not between", value1, value2, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andResourcesNameIsNull() {
            addCriterion("resources_name is null");
            return (Criteria) this;
        }

        public Criteria andResourcesNameIsNotNull() {
            addCriterion("resources_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesNameEqualTo(String value) {
            addCriterion("resources_name =", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotEqualTo(String value) {
            addCriterion("resources_name <>", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameGreaterThan(String value) {
            addCriterion("resources_name >", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameGreaterThanOrEqualTo(String value) {
            addCriterion("resources_name >=", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameLessThan(String value) {
            addCriterion("resources_name <", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameLessThanOrEqualTo(String value) {
            addCriterion("resources_name <=", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameLike(String value) {
            addCriterion("resources_name like", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotLike(String value) {
            addCriterion("resources_name not like", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameIn(List<String> values) {
            addCriterion("resources_name in", values, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotIn(List<String> values) {
            addCriterion("resources_name not in", values, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameBetween(String value1, String value2) {
            addCriterion("resources_name between", value1, value2, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotBetween(String value1, String value2) {
            addCriterion("resources_name not between", value1, value2, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceIsNull() {
            addCriterion("resources_price is null");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceIsNotNull() {
            addCriterion("resources_price is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceEqualTo(Float value) {
            addCriterion("resources_price =", value, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceNotEqualTo(Float value) {
            addCriterion("resources_price <>", value, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceGreaterThan(Float value) {
            addCriterion("resources_price >", value, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("resources_price >=", value, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceLessThan(Float value) {
            addCriterion("resources_price <", value, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceLessThanOrEqualTo(Float value) {
            addCriterion("resources_price <=", value, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceIn(List<Float> values) {
            addCriterion("resources_price in", values, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceNotIn(List<Float> values) {
            addCriterion("resources_price not in", values, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceBetween(Float value1, Float value2) {
            addCriterion("resources_price between", value1, value2, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesPriceNotBetween(Float value1, Float value2) {
            addCriterion("resources_price not between", value1, value2, "resourcesPrice");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeIsNull() {
            addCriterion("resources_createTime is null");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeIsNotNull() {
            addCriterion("resources_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeEqualTo(Date value) {
            addCriterion("resources_createTime =", value, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeNotEqualTo(Date value) {
            addCriterion("resources_createTime <>", value, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeGreaterThan(Date value) {
            addCriterion("resources_createTime >", value, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resources_createTime >=", value, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeLessThan(Date value) {
            addCriterion("resources_createTime <", value, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("resources_createTime <=", value, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeIn(List<Date> values) {
            addCriterion("resources_createTime in", values, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeNotIn(List<Date> values) {
            addCriterion("resources_createTime not in", values, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeBetween(Date value1, Date value2) {
            addCriterion("resources_createTime between", value1, value2, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("resources_createTime not between", value1, value2, "resourcesCreatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeIsNull() {
            addCriterion("resources_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeIsNotNull() {
            addCriterion("resources_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeEqualTo(Date value) {
            addCriterion("resources_updateTime =", value, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeNotEqualTo(Date value) {
            addCriterion("resources_updateTime <>", value, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeGreaterThan(Date value) {
            addCriterion("resources_updateTime >", value, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resources_updateTime >=", value, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeLessThan(Date value) {
            addCriterion("resources_updateTime <", value, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("resources_updateTime <=", value, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeIn(List<Date> values) {
            addCriterion("resources_updateTime in", values, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeNotIn(List<Date> values) {
            addCriterion("resources_updateTime not in", values, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("resources_updateTime between", value1, value2, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("resources_updateTime not between", value1, value2, "resourcesUpdatetime");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusIsNull() {
            addCriterion("resources_status is null");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusIsNotNull() {
            addCriterion("resources_status is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusEqualTo(Integer value) {
            addCriterion("resources_status =", value, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusNotEqualTo(Integer value) {
            addCriterion("resources_status <>", value, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusGreaterThan(Integer value) {
            addCriterion("resources_status >", value, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("resources_status >=", value, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusLessThan(Integer value) {
            addCriterion("resources_status <", value, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusLessThanOrEqualTo(Integer value) {
            addCriterion("resources_status <=", value, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusIn(List<Integer> values) {
            addCriterion("resources_status in", values, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusNotIn(List<Integer> values) {
            addCriterion("resources_status not in", values, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusBetween(Integer value1, Integer value2) {
            addCriterion("resources_status between", value1, value2, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("resources_status not between", value1, value2, "resourcesStatus");
            return (Criteria) this;
        }

        public Criteria andResourcesCountIsNull() {
            addCriterion("resources_count is null");
            return (Criteria) this;
        }

        public Criteria andResourcesCountIsNotNull() {
            addCriterion("resources_count is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesCountEqualTo(Integer value) {
            addCriterion("resources_count =", value, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountNotEqualTo(Integer value) {
            addCriterion("resources_count <>", value, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountGreaterThan(Integer value) {
            addCriterion("resources_count >", value, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("resources_count >=", value, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountLessThan(Integer value) {
            addCriterion("resources_count <", value, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountLessThanOrEqualTo(Integer value) {
            addCriterion("resources_count <=", value, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountIn(List<Integer> values) {
            addCriterion("resources_count in", values, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountNotIn(List<Integer> values) {
            addCriterion("resources_count not in", values, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountBetween(Integer value1, Integer value2) {
            addCriterion("resources_count between", value1, value2, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("resources_count not between", value1, value2, "resourcesCount");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeIsNull() {
            addCriterion("resources_operateType is null");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeIsNotNull() {
            addCriterion("resources_operateType is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeEqualTo(Integer value) {
            addCriterion("resources_operateType =", value, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeNotEqualTo(Integer value) {
            addCriterion("resources_operateType <>", value, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeGreaterThan(Integer value) {
            addCriterion("resources_operateType >", value, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resources_operateType >=", value, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeLessThan(Integer value) {
            addCriterion("resources_operateType <", value, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeLessThanOrEqualTo(Integer value) {
            addCriterion("resources_operateType <=", value, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeIn(List<Integer> values) {
            addCriterion("resources_operateType in", values, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeNotIn(List<Integer> values) {
            addCriterion("resources_operateType not in", values, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeBetween(Integer value1, Integer value2) {
            addCriterion("resources_operateType between", value1, value2, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesOperatetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("resources_operateType not between", value1, value2, "resourcesOperatetype");
            return (Criteria) this;
        }

        public Criteria andResourcesImageIsNull() {
            addCriterion("resources_image is null");
            return (Criteria) this;
        }

        public Criteria andResourcesImageIsNotNull() {
            addCriterion("resources_image is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesImageEqualTo(String value) {
            addCriterion("resources_image =", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageNotEqualTo(String value) {
            addCriterion("resources_image <>", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageGreaterThan(String value) {
            addCriterion("resources_image >", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageGreaterThanOrEqualTo(String value) {
            addCriterion("resources_image >=", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageLessThan(String value) {
            addCriterion("resources_image <", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageLessThanOrEqualTo(String value) {
            addCriterion("resources_image <=", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageLike(String value) {
            addCriterion("resources_image like", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageNotLike(String value) {
            addCriterion("resources_image not like", value, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageIn(List<String> values) {
            addCriterion("resources_image in", values, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageNotIn(List<String> values) {
            addCriterion("resources_image not in", values, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageBetween(String value1, String value2) {
            addCriterion("resources_image between", value1, value2, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesImageNotBetween(String value1, String value2) {
            addCriterion("resources_image not between", value1, value2, "resourcesImage");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeIsNull() {
            addCriterion("resources_transactionTime is null");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeIsNotNull() {
            addCriterion("resources_transactionTime is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeEqualTo(Integer value) {
            addCriterion("resources_transactionTime =", value, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeNotEqualTo(Integer value) {
            addCriterion("resources_transactionTime <>", value, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeGreaterThan(Integer value) {
            addCriterion("resources_transactionTime >", value, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resources_transactionTime >=", value, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeLessThan(Integer value) {
            addCriterion("resources_transactionTime <", value, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeLessThanOrEqualTo(Integer value) {
            addCriterion("resources_transactionTime <=", value, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeIn(List<Integer> values) {
            addCriterion("resources_transactionTime in", values, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeNotIn(List<Integer> values) {
            addCriterion("resources_transactionTime not in", values, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeBetween(Integer value1, Integer value2) {
            addCriterion("resources_transactionTime between", value1, value2, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesTransactiontimeNotBetween(Integer value1, Integer value2) {
            addCriterion("resources_transactionTime not between", value1, value2, "resourcesTransactiontime");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeIsNull() {
            addCriterion("resources_agencyFee is null");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeIsNotNull() {
            addCriterion("resources_agencyFee is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeEqualTo(Double value) {
            addCriterion("resources_agencyFee =", value, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeNotEqualTo(Double value) {
            addCriterion("resources_agencyFee <>", value, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeGreaterThan(Double value) {
            addCriterion("resources_agencyFee >", value, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeGreaterThanOrEqualTo(Double value) {
            addCriterion("resources_agencyFee >=", value, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeLessThan(Double value) {
            addCriterion("resources_agencyFee <", value, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeLessThanOrEqualTo(Double value) {
            addCriterion("resources_agencyFee <=", value, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeIn(List<Double> values) {
            addCriterion("resources_agencyFee in", values, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeNotIn(List<Double> values) {
            addCriterion("resources_agencyFee not in", values, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeBetween(Double value1, Double value2) {
            addCriterion("resources_agencyFee between", value1, value2, "resourcesAgencyfee");
            return (Criteria) this;
        }

        public Criteria andResourcesAgencyfeeNotBetween(Double value1, Double value2) {
            addCriterion("resources_agencyFee not between", value1, value2, "resourcesAgencyfee");
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