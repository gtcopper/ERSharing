package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * @author haojie
 * @version 1.0
 * @description 轮播图结果集
 * @date 2019/2/10 19:44
 **/
public class SlideShowResponse implements Serializable {
    /**
     * 轮播图url
     */
    private String imageUrl;
    /**
     * 轮播图title
     */
    private String title;
    /**
     * 轮播图详情url
     */
    private String detailsUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }
}
