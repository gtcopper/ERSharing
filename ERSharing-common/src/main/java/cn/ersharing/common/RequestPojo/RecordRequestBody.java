package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 *  生成记录(完成交易)的请求主体信息
 * @author haojie
 * @date 2019/1/18
 */
public class RecordRequestBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    /**
     *  共享方企业id
     */
    private Integer sharingEnterpriseId;

    /**
     *  接受方企业id
     */
    private Integer acceptEnterpriseId;

    /**
     *  支付金额
     */
    private Float recordPayment;

    /**
     *  资源id
     */
    private Integer resourcesId;

    /**
     *  资源共享数量
     */
    private Integer recordResourcesNumber;

    /**
     *  资源操作类型
     *   1 发布资源  0 需求资源
     */
    private Integer recordResourceOperatetype;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getSharingEnterpriseId() {
        return sharingEnterpriseId;
    }

    public void setSharingEnterpriseId(Integer sharingEnterpriseId) {
        this.sharingEnterpriseId = sharingEnterpriseId;
    }

    public Integer getAcceptEnterpriseId() {
        return acceptEnterpriseId;
    }

    public void setAcceptEnterpriseId(Integer acceptEnterpriseId) {
        this.acceptEnterpriseId = acceptEnterpriseId;
    }

    public Float getRecordPayment() {
        return recordPayment;
    }

    public void setRecordPayment(Float recordPayment) {
        this.recordPayment = recordPayment;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getRecordResourcesNumber() {
        return recordResourcesNumber;
    }

    public void setRecordResourcesNumber(Integer recordResourcesNumber) {
        this.recordResourcesNumber = recordResourcesNumber;
    }

    public Integer getRecordResourceOperatetype() {
        return recordResourceOperatetype;
    }

    public void setRecordResourceOperatetype(Integer recordResourceOperatetype) {
        this.recordResourceOperatetype = recordResourceOperatetype;
    }
}
