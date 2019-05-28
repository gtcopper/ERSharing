package cn.ersharing.pojo;

import java.io.Serializable;

public class EnterpriseComment implements Serializable {
    private Integer commentId;

    private Integer commentingEnterpriseId;

    private Integer commentedEnterpriseId;

    private Integer commentScore;

    private String commentImage;

    private Integer anonymityEnterprise;

    private String commentContent;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentingEnterpriseId() {
        return commentingEnterpriseId;
    }

    public void setCommentingEnterpriseId(Integer commentingEnterpriseId) {
        this.commentingEnterpriseId = commentingEnterpriseId;
    }

    public Integer getCommentedEnterpriseId() {
        return commentedEnterpriseId;
    }

    public void setCommentedEnterpriseId(Integer commentedEnterpriseId) {
        this.commentedEnterpriseId = commentedEnterpriseId;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}