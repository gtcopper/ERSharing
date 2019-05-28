package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * 企业用户完善信息返回信息主体
 * @author haojie
 * @date 2018/1/11
 */
public class CompleteEnterpriseInfoResultBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 企业名
     */
    private String enterpriseName;

    /**
     * 企业邮箱
     */
    private String enterpriseEmail;

    /**
     * 企业法人代表
     */
    private String enterpriseLegalrepresentative;


    /**
     * 营业执照的路径
     */
    private String enterpriseLicenseUrl;

    /**
     * 企业logo图片的路径
     */
    private String enterpriseLogoUrl;

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
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public String getEnterpriseLegalrepresentative() {
        return enterpriseLegalrepresentative;
    }

    public void setEnterpriseLegalrepresentative(String enterpriseLegalrepresentative) {
        this.enterpriseLegalrepresentative = enterpriseLegalrepresentative;
    }

    public String getEnterpriseLicenseUrl() {
        return enterpriseLicenseUrl;
    }

    public void setEnterpriseLicenseUrl(String enterpriseLicenseUrl) {
        this.enterpriseLicenseUrl = enterpriseLicenseUrl;
    }

    public String getEnterpriseLogoUrl() {
        return enterpriseLogoUrl;
    }

    public void setEnterpriseLogoUrl(String enterpriseLogoUrl) {
        this.enterpriseLogoUrl = enterpriseLogoUrl;
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
