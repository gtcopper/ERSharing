package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;

/**
 * 下载资源返回值
 * @author haojie
 * @date 2019/1/16
 */
public class DownloadResult implements Serializable {

    /**
     * 下载资源的url
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
