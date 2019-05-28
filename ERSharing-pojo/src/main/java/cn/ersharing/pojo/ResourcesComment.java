package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.Date;

public class ResourcesComment implements Serializable {
    private Integer commentId;

    private Integer resourcesId;

    private Integer enterpriseId;

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

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage == null ? null : commentImage.trim();
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
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}