package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;
import java.util.Date;

public class SearchResourceResult implements Serializable {

    private Integer resourcesId;

    private Integer enterpriseId;

    private String resourcesName;

    /**
     * 发布资源的地址
     */
    private String enterpriseCity;

    private String enterpriseName;

    private String enterpriseLogoUrl;

    private Date resourcesCreatetime;

    private String resourcesImage;

    private String resourcesDesc;

    private Integer scanTimes;

    private Integer praiseTimes;

    private Integer commentTimes;


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

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public String getEnterpriseCity() {
        return enterpriseCity;
    }

    public void setEnterpriseCity(String enterpriseCity) {
        this.enterpriseCity = enterpriseCity;
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

    public Date getResourcesCreatetime() {
        return resourcesCreatetime;
    }

    public void setResourcesCreatetime(Date resourcesCreatetime) {
        this.resourcesCreatetime = resourcesCreatetime;
    }

    public String getResourcesImage() {
        return resourcesImage;
    }

    public void setResourcesImage(String resourcesImage) {
        this.resourcesImage = resourcesImage;
    }

    public String getResourcesDesc() {
        return resourcesDesc;
    }

    public void setResourcesDesc(String resourcesDesc) {
        this.resourcesDesc = resourcesDesc;
    }

    public Integer getScanTimes() {
        return scanTimes;
    }

    public void setScanTimes(Integer scanTimes) {
        this.scanTimes = scanTimes;
    }

    public Integer getPraiseTimes() {
        return praiseTimes;
    }

    public void setPraiseTimes(Integer praiseTimes) {
        this.praiseTimes = praiseTimes;
    }

    public Integer getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Integer commentTimes) {
        this.commentTimes = commentTimes;
    }
}
