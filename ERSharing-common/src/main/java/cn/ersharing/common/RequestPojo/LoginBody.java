package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 登录信息主体
 * @author haojie
 * @date 219/1/10
 */
public class LoginBody implements Serializable {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

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
}
