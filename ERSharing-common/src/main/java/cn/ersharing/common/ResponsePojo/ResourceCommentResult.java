package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论返回结果集
 * @author haojie
 * @date 2019/1/16
 */
public class ResourceCommentResult implements Serializable {

    /**
     * 资源评论id
     */
    private Integer resourceCommentId;

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 企业用户名
     */
    private String enterpriseUser;

    /**
     * 企业名
     */
    private String enterpriseName;


    /**
     *  企业logo
     */
    private String enterpriseLogoUrl;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论图片
     */
    private String commentImageUrl;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 是否匿名评论 1 不匿名 0 匿名
     */
    private Integer anonymityEnterprise;

    /**
     *  判断评论是否是当前用户 1 是当前用户 0 不是当前用户
     */
    private Integer userCommentState;

    /**
     *  资源评论数
     */
    private Integer commentNums;

    public Integer getResourceCommentId() {
        return resourceCommentId;
    }

    public void setResourceCommentId(Integer resourceCommentId) {
        this.resourceCommentId = resourceCommentId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getEnterpriseUser() {
        return enterpriseUser;
    }

    public void setEnterpriseUser(String enterpriseUser) {
        this.enterpriseUser = enterpriseUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentImageUrl() {
        return commentImageUrl;
    }

    public void setCommentImageUrl(String commentImageUrl) {
        this.commentImageUrl = commentImageUrl;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getAnonymityEnterprise() {
        return anonymityEnterprise;
    }

    public void setAnonymityEnterprise(Integer anonymityEnterprise) {
        this.anonymityEnterprise = anonymityEnterprise;
    }

    public Integer getUserCommentState() {
        return userCommentState;
    }

    public void setUserCommentState(Integer userCommentState) {
        this.userCommentState = userCommentState;
    }

    public Integer getCommentNums() {
        return commentNums;
    }

    public void setCommentNums(Integer commentNums) {
        this.commentNums = commentNums;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseLogoUrl() {
        return enterpriseLogoUrl;
    }

    public void setEnterpriseLogoUrl(String enterpriseLogoUrl) {
        this.enterpriseLogoUrl = enterpriseLogoUrl;
    }
}
