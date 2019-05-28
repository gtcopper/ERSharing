package cn.ersharing.common.ResponsePojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author haojie
 * @version 1.0
 * @description 轮播图响应结果
 * @date 2019/2/10 19:38
 **/
public class SlidesShowResult implements Serializable {
    private long total;

    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
