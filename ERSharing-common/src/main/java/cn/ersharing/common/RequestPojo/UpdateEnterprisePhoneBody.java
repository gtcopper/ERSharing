package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 修改企业手机号信息主体
 * @author haojie
 * @date 2019/1/11
 */
public class UpdateEnterprisePhoneBody implements Serializable {

    /**
     * 用户token
     */
    private String token;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 手机验证码
     */
    private String checkCode;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
