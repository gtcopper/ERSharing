package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * 查看用户地址列表结果集
 * @author haojie
 * @date 2019/12
 */
public class EnterpriseAddressResult implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 企业id
     */
    private Integer enterpriseId;

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
