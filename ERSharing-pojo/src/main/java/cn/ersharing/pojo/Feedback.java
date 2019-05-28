package cn.ersharing.pojo;

import java.io.Serializable;

public class Feedback implements Serializable {
    private Integer feedbackId;

    private String feedbackImage;

    private String feedbackText;

    private Integer enterpriseId;

    private Integer anonmity;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackImage() {
        return feedbackImage;
    }

    public void setFeedbackImage(String feedbackImage) {
        this.feedbackImage = feedbackImage == null ? null : feedbackImage.trim();
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText == null ? null : feedbackText.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getAnonmity() {
        return anonmity;
    }

    public void setAnonmity(Integer anonmity) {
        this.anonmity = anonmity;
    }
}