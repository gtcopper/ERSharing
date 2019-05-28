package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 *  关注请求信息主体
 * @author haojie
 * @date 2019/1/16
 */
public class InformRequestBody implements Serializable {

    /**
     * 用户标识信息
     */
    private String token;

    /**
     * 关注的公司id
     */
    private Integer enterpriseFollowId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getEnterpriseFollowId() {
        return enterpriseFollowId;
    }

    public void setEnterpriseFollowId(Integer enterpriseFollowId) {
        this.enterpriseFollowId = enterpriseFollowId;
    }
}
