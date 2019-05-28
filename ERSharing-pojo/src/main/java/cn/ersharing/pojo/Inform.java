package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.Date;

public class Inform implements Serializable {
    private Integer informId;

    private Integer enterpriseId;

    private Integer enterpriseFollowid;

    private Date followTime;

    public Integer getInformId() {
        return informId;
    }

    public void setInformId(Integer informId) {
        this.informId = informId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getEnterpriseFollowid() {
        return enterpriseFollowid;
    }

    public void setEnterpriseFollowid(Integer enterpriseFollowid) {
        this.enterpriseFollowid = enterpriseFollowid;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}