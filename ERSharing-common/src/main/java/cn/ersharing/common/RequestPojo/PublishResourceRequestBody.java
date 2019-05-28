package cn.ersharing.common.RequestPojo;

import java.io.Serializable;
import java.util.Date;

/**
 *  资源发布信息主体
 * @author haojie
 * @date 20189/1/18
 */
public class PublishResourceRequestBody implements Serializable {

    /**
     * 用户信息标识
     */
    private String token;

    private Integer resourcesCategoryId;

    private String enterpriseCity;

    private String resourcesName;

    private Float resourcesPrice;

    private Integer resourcesCount;

    private Integer resourcesOperatetype;

    private Double resourcesAgencyfee;

    private String resourcesDesc;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getResourcesCategoryId() {
        return resourcesCategoryId;
    }

    public void setResourcesCategoryId(Integer resourcesCategoryId) {
        this.resourcesCategoryId = resourcesCategoryId;
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

    public String getResourcesDesc() {
        return resourcesDesc;
    }

    public void setResourcesDesc(String resourcesDesc) {
        this.resourcesDesc = resourcesDesc;
    }
}
