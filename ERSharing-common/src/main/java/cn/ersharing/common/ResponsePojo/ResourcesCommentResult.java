package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haojie
 * @version 1.0
 * @description 查看资源评论返回结果
 * @date 2019/5/6 19:39
 **/
public class ResourcesCommentResult implements Serializable {
    private Integer commentId;

    private Integer resourcesId;

    private Integer enterpriseId;

    /**
     * 企业名
     */
    private String enterpriseName;

    /**
     *  企业logo
     */
    private String enterpriseLogoUrl;

    private String commentImage;

    private Integer anonymityEnterprise;

    private Date commentTime;

    private String commentContent;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
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

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    public Integer getAnonymityEnterprise() {
        return anonymityEnterprise;
    }

    public void setAnonymityEnterprise(Integer anonymityEnterprise) {
        this.anonymityEnterprise = anonymityEnterprise;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
