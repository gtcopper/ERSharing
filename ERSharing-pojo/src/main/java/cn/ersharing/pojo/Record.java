package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {
    private Integer recordId;

    private Integer sharingEnterpriseId;

    private Integer acceptEnterpriseId;

    private Date recordTradetime;

    private Float recordPayment;

    private Integer resourcesId;

    private Integer recordResourcesNumber;

    private Integer recordResourceOperatetype;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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

    public Date getRecordTradetime() {
        return recordTradetime;
    }

    public void setRecordTradetime(Date recordTradetime) {
        this.recordTradetime = recordTradetime;
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