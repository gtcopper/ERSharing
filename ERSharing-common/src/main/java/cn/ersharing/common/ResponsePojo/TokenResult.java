package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * 用户登录返回token信息
 * @author haojie
 * @date 2018/1/10
 */
public class TokenResult implements Serializable {
    /**
     * 登录后生成的token值
     */
    private String token;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 企业用户名
     */
    private String enterprise_user;

    /**
     * 企业用户手机号
     */
    private String phone;

    private String enterpriseLogo;

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

    public String getEnterprise_user() {
        return enterprise_user;
    }

    public void setEnterprise_user(String enterprise_user) {
        this.enterprise_user = enterprise_user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo;
    }
}
