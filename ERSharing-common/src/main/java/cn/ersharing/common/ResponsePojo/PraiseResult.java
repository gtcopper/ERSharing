package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * 点赞结果返回
 * @author haojie
 * @date 2019/1/16
 */
public class PraiseResult implements Serializable {

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 资源点赞树
     */
    private Integer praiseNums;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getPraiseNums() {
        return praiseNums;
    }

    public void setPraiseNums(Integer praiseNums) {
        this.praiseNums = praiseNums;
    }
}
