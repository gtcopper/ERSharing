package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 企业用户忘记密码
 * @author haojie
 * @date 2018/1/11
 */
public class ForgetPasswordBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 短信验证码
     */
    private String checkCode;

    /**
     * 新密码
     */
    private String newPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
