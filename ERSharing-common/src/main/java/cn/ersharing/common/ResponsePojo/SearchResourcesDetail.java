package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询资源的结果集
 * @author haojie
 * @date 2019/1/17
 */
public class SearchResourcesDetail implements Serializable {


    private Integer resourcesId;

    private Integer resourcesCategoryId;

    private String categoryName;

    private Integer enterpriseId;

    /**
     * 发布资源的地址
     */
    private String enterpriseCity;

    private String resourcesName;

    private Float resourcesPrice;

    private Date resourcesCreatetime;

    private Date resourcesUpdatetime;

    private Integer resourcesStatus;

    private Integer resourcesCount;

    private Integer resourcesOperatetype;

    private Double resourcesAgencyfee;

    private String resourcesImage;

    private Integer resourcesTransactiontime;

    private String resourcesDesc;

    private String enterpriseName;

    private String enterpriseLogoUrl;

    private String resourcesDescription;


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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        this.enterpriseCity = enterpriseCity;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
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

    public Double getResourcesAgencyfee() {
        return resourcesAgencyfee;
    }

    public void setResourcesAgencyfee(Double resourcesAgencyfee) {
        this.resourcesAgencyfee = resourcesAgencyfee;
    }

    public String getResourcesImage() {
        return resourcesImage;
    }

    public void setResourcesImage(String resourcesImage) {
        this.resourcesImage = resourcesImage;
    }

    public Integer getResourcesTransactiontime() {
        return resourcesTransactiontime;
    }

    public void setResourcesTransactiontime(Integer resourcesTransactiontime) {
        this.resourcesTransactiontime = resourcesTransactiontime;
    }

    public String getResourcesDesc() {
        return resourcesDesc;
    }

    public void setResourcesDesc(String resourcesDesc) {
        this.resourcesDesc = resourcesDesc;
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

    public String getResourcesDescription() {
        return resourcesDescription;
    }

    public void setResourcesDescription(String resourcesDescription) {
        this.resourcesDescription = resourcesDescription;
    }
}
