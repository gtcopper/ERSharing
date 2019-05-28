package cn.ersharing.pojo;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseCommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdIsNull() {
            addCriterion("commenting_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdIsNotNull() {
            addCriterion("commenting_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdEqualTo(Integer value) {
            addCriterion("commenting_enterprise_id =", value, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("commenting_enterprise_id <>", value, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdGreaterThan(Integer value) {
            addCriterion("commenting_enterprise_id >", value, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commenting_enterprise_id >=", value, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdLessThan(Integer value) {
            addCriterion("commenting_enterprise_id <", value, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("commenting_enterprise_id <=", value, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdIn(List<Integer> values) {
            addCriterion("commenting_enterprise_id in", values, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("commenting_enterprise_id not in", values, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("commenting_enterprise_id between", value1, value2, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentingEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commenting_enterprise_id not between", value1, value2, "commentingEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdIsNull() {
            addCriterion("commented_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdIsNotNull() {
            addCriterion("commented_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdEqualTo(Integer value) {
            addCriterion("commented_enterprise_id =", value, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("commented_enterprise_id <>", value, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdGreaterThan(Integer value) {
            addCriterion("commented_enterprise_id >", value, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commented_enterprise_id >=", value, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdLessThan(Integer value) {
            addCriterion("commented_enterprise_id <", value, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("commented_enterprise_id <=", value, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdIn(List<Integer> values) {
            addCriterion("commented_enterprise_id in", values, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("commented_enterprise_id not in", values, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("commented_enterprise_id between", value1, value2, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentedEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commented_enterprise_id not between", value1, value2, "commentedEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIsNull() {
            addCriterion("comment_score is null");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIsNotNull() {
            addCriterion("comment_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommentScoreEqualTo(Integer value) {
            addCriterion("comment_score =", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotEqualTo(Integer value) {
            addCriterion("comment_score <>", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreGreaterThan(Integer value) {
            addCriterion("comment_score >", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_score >=", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLessThan(Integer value) {
            addCriterion("comment_score <", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLessThanOrEqualTo(Integer value) {
            addCriterion("comment_score <=", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIn(List<Integer> values) {
            addCriterion("comment_score in", values, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotIn(List<Integer> values) {
            addCriterion("comment_score not in", values, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreBetween(Integer value1, Integer value2) {
            addCriterion("comment_score between", value1, value2, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_score not between", value1, value2, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentImageIsNull() {
            addCriterion("comment_image is null");
            return (Criteria) this;
        }

        public Criteria andCommentImageIsNotNull() {
            addCriterion("comment_image is not null");
            return (Criteria) this;
        }

        public Criteria andCommentImageEqualTo(String value) {
            addCriterion("comment_image =", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotEqualTo(String value) {
            addCriterion("comment_image <>", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageGreaterThan(String value) {
            addCriterion("comment_image >", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageGreaterThanOrEqualTo(String value) {
            addCriterion("comment_image >=", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageLessThan(String value) {
            addCriterion("comment_image <", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageLessThanOrEqualTo(String value) {
            addCriterion("comment_image <=", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageLike(String value) {
            addCriterion("comment_image like", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotLike(String value) {
            addCriterion("comment_image not like", value, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageIn(List<String> values) {
            addCriterion("comment_image in", values, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotIn(List<String> values) {
            addCriterion("comment_image not in", values, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageBetween(String value1, String value2) {
            addCriterion("comment_image between", value1, value2, "commentImage");
            return (Criteria) this;
        }

        public Criteria andCommentImageNotBetween(String value1, String value2) {
            addCriterion("comment_image not between", value1, value2, "commentImage");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseIsNull() {
            addCriterion("anonymity_enterprise is null");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseIsNotNull() {
            addCriterion("anonymity_enterprise is not null");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseEqualTo(Integer value) {
            addCriterion("anonymity_enterprise =", value, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseNotEqualTo(Integer value) {
            addCriterion("anonymity_enterprise <>", value, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseGreaterThan(Integer value) {
            addCriterion("anonymity_enterprise >", value, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseGreaterThanOrEqualTo(Integer value) {
            addCriterion("anonymity_enterprise >=", value, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseLessThan(Integer value) {
            addCriterion("anonymity_enterprise <", value, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseLessThanOrEqualTo(Integer value) {
            addCriterion("anonymity_enterprise <=", value, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseIn(List<Integer> values) {
            addCriterion("anonymity_enterprise in", values, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseNotIn(List<Integer> values) {
            addCriterion("anonymity_enterprise not in", values, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseBetween(Integer value1, Integer value2) {
            addCriterion("anonymity_enterprise between", value1, value2, "anonymityEnterprise");
            return (Criteria) this;
        }

        public Criteria andAnonymityEnterpriseNotBetween(Integer value1, Integer value2) {
            addCriterion("anonymity_enterprise not between", value1, value2, "anonymityEnterprise");
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