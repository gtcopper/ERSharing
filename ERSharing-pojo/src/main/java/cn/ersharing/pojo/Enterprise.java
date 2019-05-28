package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.Date;

public class Enterprise implements Serializable {
    private Integer enterpriseId;

    private String enterpriseName;

    private String enterpriseLicense;

    private String enterpriseLegalrepresentative;

    private Date enterpriseIssuedate;

    private Integer enterpriseCategoryId;

    private String enterpriseEmail;

    private Integer informId;

    private String enterpriseLogo;

    private Integer enterpriseTransactiontime;

    private String enterpriseUser;

    private String enterprisePassword;

    private String enterprisePhone;

    private String enterpriseAddress;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEnterpriseLicense() {
        return enterpriseLicense;
    }

    public void setEnterpriseLicense(String enterpriseLicense) {
        this.enterpriseLicense = enterpriseLicense == null ? null : enterpriseLicense.trim();
    }

    public String getEnterpriseLegalrepresentative() {
        return enterpriseLegalrepresentative;
    }

    public void setEnterpriseLegalrepresentative(String enterpriseLegalrepresentative) {
        this.enterpriseLegalrepresentative = enterpriseLegalrepresentative == null ? null : enterpriseLegalrepresentative.trim();
    }

    public Date getEnterpriseIssuedate() {
        return enterpriseIssuedate;
    }

    public void setEnterpriseIssuedate(Date enterpriseIssuedate) {
        this.enterpriseIssuedate = enterpriseIssuedate;
    }

    public Integer getEnterpriseCategoryId() {
        return enterpriseCategoryId;
    }

    public void setEnterpriseCategoryId(Integer enterpriseCategoryId) {
        this.enterpriseCategoryId = enterpriseCategoryId;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail == null ? null : enterpriseEmail.trim();
    }

    public Integer getInformId() {
        return informId;
    }

    public void setInformId(Integer informId) {
        this.informId = informId;
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo == null ? null : enterpriseLogo.trim();
    }

    public Integer getEnterpriseTransactiontime() {
        return enterpriseTransactiontime;
    }

    public void setEnterpriseTransactiontime(Integer enterpriseTransactiontime) {
        this.enterpriseTransactiontime = enterpriseTransactiontime;
    }

    public String getEnterpriseUser() {
        return enterpriseUser;
    }

    public void setEnterpriseUser(String enterpriseUser) {
        this.enterpriseUser = enterpriseUser == null ? null : enterpriseUser.trim();
    }

    public String getEnterprisePassword() {
        return enterprisePassword;
    }

    public void setEnterprisePassword(String enterprisePassword) {
        this.enterprisePassword = enterprisePassword == null ? null : enterprisePassword.trim();
    }

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone == null ? null : enterprisePhone.trim();
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress == null ? null : enterpriseAddress.trim();
    }
}