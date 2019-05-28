package cn.ersharing.pojo;

import java.io.Serializable;
import java.util.Date;

public class Resources implements Serializable {
    private Integer resourcesId;

    private Integer resourcesCategoryId;

    private Integer enterpriseId;

    private String enterpriseCity;

    private String resourcesName;

    private Float resourcesPrice;

    private Date resourcesCreatetime;

    private Date resourcesUpdatetime;

    private Integer resourcesStatus;

    private Integer resourcesCount;

    private Integer resourcesOperatetype;

    private String resourcesImage;

    private Integer resourcesTransactiontime;

    private Double resourcesAgencyfee;

    private String resourcesDesc;

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getResourcesCategoryId() {
        return resourcesCategoryId;
    }

    public void setResourcesCategoryId(Integer resourcesCategoryId) {
        this.resourcesCategoryId = resourcesCategoryId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseCity() {
        return enterpriseCity;
    }

    public void setEnterpriseCity(String enterpriseCity) {
        this.enterpriseCity = enterpriseCity == null ? null : enterpriseCity.trim();
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName == null ? null : resourcesName.trim();
    }

    public Float getResourcesPrice() {
        return resourcesPrice;
    }

    public void setResourcesPrice(Float resourcesPrice) {
        this.resourcesPrice = resourcesPrice;
    }

    public Date getResourcesCreatetime() {
        return resourcesCreatetime;
    }

    public void setResourcesCreatetime(Date resourcesCreatetime) {
        this.resourcesCreatetime = resourcesCreatetime;
    }

    public Date getResourcesUpdatetime() {
        return resourcesUpdatetime;
    }

    public void setResourcesUpdatetime(Date resourcesUpdatetime) {
        this.resourcesUpdatetime = resourcesUpdatetime;
    }

    public Integer getResourcesStatus() {
        return resourcesStatus;
    }

    public void setResourcesStatus(Integer resourcesStatus) {
        this.resourcesStatus = resourcesStatus;
    }

    public Integer getResourcesCount() {
        return resourcesCount;
    }

    public void setResourcesCount(Integer resourcesCount) {
        this.resourcesCount = resourcesCount;
    }

    public Integer getResourcesOperatetype() {
        return resourcesOperatetype;
    }

    public void setResourcesOperatetype(Integer resourcesOperatetype) {
        this.resourcesOperatetype = resourcesOperatetype;
    }

    public String getResourcesImage() {
        return resourcesImage;
    }

    public void setResourcesImage(String resourcesImage) {
        this.resourcesImage = resourcesImage == null ? null : resourcesImage.trim();
    }

    public Integer getResourcesTransactiontime() {
        return resourcesTransactiontime;
    }

    public void setResourcesTransactiontime(Integer resourcesTransactiontime) {
        this.resourcesTransactiontime = resourcesTransactiontime;
    }

    public Double getResourcesAgencyfee() {
        return resourcesAgencyfee;
    }

    public void setResourcesAgencyfee(Double resourcesAgencyfee) {
        this.resourcesAgencyfee = resourcesAgencyfee;
    }

    public String getResourcesDesc() {
        return resourcesDesc;
    }

    public void setResourcesDesc(String resourcesDesc) {
        this.resourcesDesc = resourcesDesc == null ? null : resourcesDesc.trim();
    }
}