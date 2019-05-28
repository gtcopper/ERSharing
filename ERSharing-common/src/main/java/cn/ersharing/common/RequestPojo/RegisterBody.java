package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 注册主体信息
 * @author haojie
 * @date 219/1/10
 */
public class RegisterBody implements Serializable {
    /**
     * 公司登录用户名
     */
    private String enterprise_user;
    /**
     * 公司联系方式
     */
    private String phone;
    /**
     * 登录密码
     */
    private String password;

    /**
     * 短信验证码
     */
    private String checkCode;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
