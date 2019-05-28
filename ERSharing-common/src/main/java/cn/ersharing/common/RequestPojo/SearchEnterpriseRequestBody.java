package cn.ersharing.common.RequestPojo;

import java.io.Serializable;

/**
 * 搜索参数
 */
public class SearchEnterpriseRequestBody implements Serializable {

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 企业名
     */
    private String enterpriseName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
