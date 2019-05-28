package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 修改企业密码主体信息
 * @author haojie
 * @date 2019/1/11
 */
public class UpdateEnterprisePasswordBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 企业旧密码
     */
    private String oldPassword;

    /**
     * 企业新密码
     */
    private String newPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
