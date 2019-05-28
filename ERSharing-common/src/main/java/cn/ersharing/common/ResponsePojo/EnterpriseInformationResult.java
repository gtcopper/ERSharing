package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * id查看资源详细信息的结果集
 * @author haojei
 * @date 2019/1/16
 */
public class EnterpriseInformationResult implements Serializable {

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 企业名
     */
    private String enterpriseName;


    /**
     *  企业地址
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

    /**
     * 营业执照
     */
    private String enterpriseLicenseUrl;

    /**
     * 企业logo
     */
    private String enterpriseLogoUrl;

    /**
     * 企业法人代表
     */
    private String enterpriseLegalrepresentative;

    /**
     * 关注数
     */
    private Integer informNums;

    /**
     * 是否关注 1 关注 0 未关注
     */
    private Integer focus;


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

    public String getEnterpriseLegalrepresentative() {
        return enterpriseLegalrepresentative;
    }

    public void setEnterpriseLegalrepresentative(String enterpriseLegalrepresentative) {
        this.enterpriseLegalrepresentative = enterpriseLegalrepresentative;
    }

    public Integer getInformNums() {
        return informNums;
    }

    public void setInformNums(Integer informNums) {
        this.informNums = informNums;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }
}
