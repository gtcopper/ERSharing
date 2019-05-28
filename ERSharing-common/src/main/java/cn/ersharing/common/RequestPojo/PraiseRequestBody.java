package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 点赞(取消点赞)请求主体
 * @author haojie
 * @date 2019/1/16
 */
public class PraiseRequestBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 资源id
     */
    private Integer resourceId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
