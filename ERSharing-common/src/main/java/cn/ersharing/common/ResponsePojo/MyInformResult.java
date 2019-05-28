package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author haojie
 * @version 1.0
 * @description 我的关注返回结果集
 * @date 2019/2/12 20:03
 **/
public class MyInformResult implements Serializable {
    private Integer informId;

    private Integer enterpriseId;

    private Integer enterpriseFollowid;

    private Date followTime;

    private String enterpriseName;

    private String enterpriseLogo;

    private List<HotResourceResult> resources;

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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo;
    }

    public List<HotResourceResult> getResources() {
        return resources;
    }

    public void setResources(List<HotResourceResult> resources) {
        this.resources = resources;
    }
}
