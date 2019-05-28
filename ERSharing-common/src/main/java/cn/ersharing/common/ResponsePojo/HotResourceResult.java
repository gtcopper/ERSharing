package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * @author haojie
 * @version 1.0
 * @description 热门资源结果集
 * @date 2019/2/12 15:03
 **/
public class HotResourceResult extends SearchResourcesDetail implements Serializable {
    /**
     * 资源浏览次数
     */
    private Long scanTimes;
    /**
     * 资源点赞次数
     */
    private Long priaseTimes;
    /**
     * 资源评论次数
     */
    private Long commentTimes;

    /**
     * 判断当前用户是否点赞资源
     * 1 已点赞 0 未点赞
     */
    private int praise;

    public Long getScanTimes() {
        return scanTimes;
    }

    public void setScanTimes(Long scanTimes) {
        this.scanTimes = scanTimes;
    }

    public Long getPriaseTimes() {
        return priaseTimes;
    }

    public void setPriaseTimes(Long priaseTimes) {
        this.priaseTimes = priaseTimes;
    }

    public Long getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Long commentTimes) {
        this.commentTimes = commentTimes;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }
}
