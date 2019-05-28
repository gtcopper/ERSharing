package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 反馈请求主体
 * @author haojie
 * @date 2019/1/16
 */
public class FeedbackRequestBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     * 反馈内容
     */
    private String feedbackText;

    /**
     * 是否匿名 1 不匿名 0 匿名
     */
    private Integer anonmity;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public Integer getAnonmity() {
        return anonmity;
    }

    public void setAnonmity(Integer anonmity) {
        this.anonmity = anonmity;
    }
}
