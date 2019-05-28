package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 *  资源评论请求主体
 * @author haojie
 * @date 2019/1/16
 */
public class ResourceCommentRequestBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 是否匿名评论 1 不匿名 0 匿名
     */
    private Integer anonymityEnterprise;


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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getAnonymityEnterprise() {
        return anonymityEnterprise;
    }

    public void setAnonymityEnterprise(Integer anonymityEnterprise) {
        this.anonymityEnterprise = anonymityEnterprise;
    }
}
