package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 管理员登录主体信息
 * @author haojie
 * @date 2019/1/16
 */
public class ManagerLoginBody implements Serializable {

    /**
     * 管理员账号
     */
    private String managerName;

    /**
     * 管理员密码
     */
    private String managerPassword;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
}
