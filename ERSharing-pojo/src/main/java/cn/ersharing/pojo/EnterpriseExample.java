package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseExample() {
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

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseIsNull() {
            addCriterion("enterprise_license is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseIsNotNull() {
            addCriterion("enterprise_license is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseEqualTo(String value) {
            addCriterion("enterprise_license =", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseNotEqualTo(String value) {
            addCriterion("enterprise_license <>", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseGreaterThan(String value) {
            addCriterion("enterprise_license >", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_license >=", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseLessThan(String value) {
            addCriterion("enterprise_license <", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseLessThanOrEqualTo(String value) {
            addCriterion("enterprise_license <=", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseLike(String value) {
            addCriterion("enterprise_license like", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseNotLike(String value) {
            addCriterion("enterprise_license not like", value, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseIn(List<String> values) {
            addCriterion("enterprise_license in", values, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseNotIn(List<String> values) {
            addCriterion("enterprise_license not in", values, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseBetween(String value1, String value2) {
            addCriterion("enterprise_license between", value1, value2, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLicenseNotBetween(String value1, String value2) {
            addCriterion("enterprise_license not between", value1, value2, "enterpriseLicense");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeIsNull() {
            addCriterion("enterprise_legalRepresentative is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeIsNotNull() {
            addCriterion("enterprise_legalRepresentative is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeEqualTo(String value) {
            addCriterion("enterprise_legalRepresentative =", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeNotEqualTo(String value) {
            addCriterion("enterprise_legalRepresentative <>", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeGreaterThan(String value) {
            addCriterion("enterprise_legalRepresentative >", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_legalRepresentative >=", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeLessThan(String value) {
            addCriterion("enterprise_legalRepresentative <", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeLessThanOrEqualTo(String value) {
            addCriterion("enterprise_legalRepresentative <=", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeLike(String value) {
            addCriterion("enterprise_legalRepresentative like", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeNotLike(String value) {
            addCriterion("enterprise_legalRepresentative not like", value, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeIn(List<String> values) {
            addCriterion("enterprise_legalRepresentative in", values, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeNotIn(List<String> values) {
            addCriterion("enterprise_legalRepresentative not in", values, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeBetween(String value1, String value2) {
            addCriterion("enterprise_legalRepresentative between", value1, value2, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalrepresentativeNotBetween(String value1, String value2) {
            addCriterion("enterprise_legalRepresentative not between", value1, value2, "enterpriseLegalrepresentative");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateIsNull() {
            addCriterion("enterprise_issueDate is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateIsNotNull() {
            addCriterion("enterprise_issueDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateEqualTo(Date value) {
            addCriterion("enterprise_issueDate =", value, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateNotEqualTo(Date value) {
            addCriterion("enterprise_issueDate <>", value, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateGreaterThan(Date value) {
            addCriterion("enterprise_issueDate >", value, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterion("enterprise_issueDate >=", value, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateLessThan(Date value) {
            addCriterion("enterprise_issueDate <", value, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateLessThanOrEqualTo(Date value) {
            addCriterion("enterprise_issueDate <=", value, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateIn(List<Date> values) {
            addCriterion("enterprise_issueDate in", values, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateNotIn(List<Date> values) {
            addCriterion("enterprise_issueDate not in", values, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateBetween(Date value1, Date value2) {
            addCriterion("enterprise_issueDate between", value1, value2, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIssuedateNotBetween(Date value1, Date value2) {
            addCriterion("enterprise_issueDate not between", value1, value2, "enterpriseIssuedate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdIsNull() {
            addCriterion("enterprise_category_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdIsNotNull() {
            addCriterion("enterprise_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdEqualTo(Integer value) {
            addCriterion("enterprise_category_id =", value, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdNotEqualTo(Integer value) {
            addCriterion("enterprise_category_id <>", value, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdGreaterThan(Integer value) {
            addCriterion("enterprise_category_id >", value, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_category_id >=", value, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdLessThan(Integer value) {
            addCriterion("enterprise_category_id <", value, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_category_id <=", value, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdIn(List<Integer> values) {
            addCriterion("enterprise_category_id in", values, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdNotIn(List<Integer> values) {
            addCriterion("enterprise_category_id not in", values, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_category_id between", value1, value2, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_category_id not between", value1, value2, "enterpriseCategoryId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIsNull() {
            addCriterion("enterprise_email is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIsNotNull() {
            addCriterion("enterprise_email is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailEqualTo(String value) {
            addCriterion("enterprise_email =", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotEqualTo(String value) {
            addCriterion("enterprise_email <>", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailGreaterThan(String value) {
            addCriterion("enterprise_email >", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_email >=", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLessThan(String value) {
            addCriterion("enterprise_email <", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLessThanOrEqualTo(String value) {
            addCriterion("enterprise_email <=", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLike(String value) {
            addCriterion("enterprise_email like", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotLike(String value) {
            addCriterion("enterprise_email not like", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIn(List<String> values) {
            addCriterion("enterprise_email in", values, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotIn(List<String> values) {
            addCriterion("enterprise_email not in", values, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailBetween(String value1, String value2) {
            addCriterion("enterprise_email between", value1, value2, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotBetween(String value1, String value2) {
            addCriterion("enterprise_email not between", value1, value2, "enterpriseEmail");
            return (Criteria) this;
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

        public Criteria andEnterpriseLogoIsNull() {
            addCriterion("enterprise_logo is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoIsNotNull() {
            addCriterion("enterprise_logo is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoEqualTo(String value) {
            addCriterion("enterprise_logo =", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoNotEqualTo(String value) {
            addCriterion("enterprise_logo <>", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoGreaterThan(String value) {
            addCriterion("enterprise_logo >", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_logo >=", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoLessThan(String value) {
            addCriterion("enterprise_logo <", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoLessThanOrEqualTo(String value) {
            addCriterion("enterprise_logo <=", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoLike(String value) {
            addCriterion("enterprise_logo like", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoNotLike(String value) {
            addCriterion("enterprise_logo not like", value, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoIn(List<String> values) {
            addCriterion("enterprise_logo in", values, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoNotIn(List<String> values) {
            addCriterion("enterprise_logo not in", values, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoBetween(String value1, String value2) {
            addCriterion("enterprise_logo between", value1, value2, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLogoNotBetween(String value1, String value2) {
            addCriterion("enterprise_logo not between", value1, value2, "enterpriseLogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeIsNull() {
            addCriterion("enterprise_transactionTime is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeIsNotNull() {
            addCriterion("enterprise_transactionTime is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeEqualTo(Integer value) {
            addCriterion("enterprise_transactionTime =", value, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeNotEqualTo(Integer value) {
            addCriterion("enterprise_transactionTime <>", value, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeGreaterThan(Integer value) {
            addCriterion("enterprise_transactionTime >", value, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_transactionTime >=", value, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeLessThan(Integer value) {
            addCriterion("enterprise_transactionTime <", value, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_transactionTime <=", value, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeIn(List<Integer> values) {
            addCriterion("enterprise_transactionTime in", values, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeNotIn(List<Integer> values) {
            addCriterion("enterprise_transactionTime not in", values, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_transactionTime between", value1, value2, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTransactiontimeNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_transactionTime not between", value1, value2, "enterpriseTransactiontime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserIsNull() {
            addCriterion("enterprise_user is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserIsNotNull() {
            addCriterion("enterprise_user is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserEqualTo(String value) {
            addCriterion("enterprise_user =", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotEqualTo(String value) {
            addCriterion("enterprise_user <>", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserGreaterThan(String value) {
            addCriterion("enterprise_user >", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_user >=", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserLessThan(String value) {
            addCriterion("enterprise_user <", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserLessThanOrEqualTo(String value) {
            addCriterion("enterprise_user <=", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserLike(String value) {
            addCriterion("enterprise_user like", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotLike(String value) {
            addCriterion("enterprise_user not like", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserIn(List<String> values) {
            addCriterion("enterprise_user in", values, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotIn(List<String> values) {
            addCriterion("enterprise_user not in", values, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserBetween(String value1, String value2) {
            addCriterion("enterprise_user between", value1, value2, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotBetween(String value1, String value2) {
            addCriterion("enterprise_user not between", value1, value2, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordIsNull() {
            addCriterion("enterprise_password is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordIsNotNull() {
            addCriterion("enterprise_password is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordEqualTo(String value) {
            addCriterion("enterprise_password =", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordNotEqualTo(String value) {
            addCriterion("enterprise_password <>", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordGreaterThan(String value) {
            addCriterion("enterprise_password >", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_password >=", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordLessThan(String value) {
            addCriterion("enterprise_password <", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordLessThanOrEqualTo(String value) {
            addCriterion("enterprise_password <=", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordLike(String value) {
            addCriterion("enterprise_password like", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordNotLike(String value) {
            addCriterion("enterprise_password not like", value, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordIn(List<String> values) {
            addCriterion("enterprise_password in", values, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordNotIn(List<String> values) {
            addCriterion("enterprise_password not in", values, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordBetween(String value1, String value2) {
            addCriterion("enterprise_password between", value1, value2, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePasswordNotBetween(String value1, String value2) {
            addCriterion("enterprise_password not between", value1, value2, "enterprisePassword");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneIsNull() {
            addCriterion("enterprise_phone is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneIsNotNull() {
            addCriterion("enterprise_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneEqualTo(String value) {
            addCriterion("enterprise_phone =", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneNotEqualTo(String value) {
            addCriterion("enterprise_phone <>", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneGreaterThan(String value) {
            addCriterion("enterprise_phone >", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_phone >=", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneLessThan(String value) {
            addCriterion("enterprise_phone <", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneLessThanOrEqualTo(String value) {
            addCriterion("enterprise_phone <=", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneLike(String value) {
            addCriterion("enterprise_phone like", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneNotLike(String value) {
            addCriterion("enterprise_phone not like", value, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneIn(List<String> values) {
            addCriterion("enterprise_phone in", values, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneNotIn(List<String> values) {
            addCriterion("enterprise_phone not in", values, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneBetween(String value1, String value2) {
            addCriterion("enterprise_phone between", value1, value2, "enterprisePhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePhoneNotBetween(String value1, String value2) {
            addCriterion("enterprise_phone not between", value1, value2, "enterprisePhone");
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