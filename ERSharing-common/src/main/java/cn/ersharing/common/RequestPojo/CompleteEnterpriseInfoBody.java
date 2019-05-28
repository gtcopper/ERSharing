package cn.ersharing.common.RequestPojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 完善企业信息主体
 * @author haojie
 * @date 2018/1/11
 */
public class CompleteEnterpriseInfoBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 企业名
     */
    private String enterpriseName;

    /**
     * 企业法人代表
     */
    private String enterpriseLegalrepresentative;

    /**
     * 企业邮箱
     */
    private String enterpriseEmail;

    /**
     * 企业地址
     */
    private String enterpriseAddress;

    /**
     * 企业所在省份
     */
    private String enterpriseProvince;

    /**
     * 企业所在城市
     */
    private String enterpriseCity;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseLegalrepresentative() {
        return enterpriseLegalrepresentative;
    }

    public void setEnterpriseLegalrepresentative(String enterpriseLegalrepresentative) {
        this.enterpriseLegalrepresentative = enterpriseLegalrepresentative;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getEnterpriseProvince() {
        return enterpriseProvince;
    }

    public void setEnterpriseProvince(String enterpriseProvince) {
        this.enterpriseProvince = enterpriseProvince;
    }

    public String getEnterpriseCity() {
        return enterpriseCity;
    }

    public void setEnterpriseCity(String enterpriseCity) {
        this.enterpriseCity = enterpriseCity;
    }
}
