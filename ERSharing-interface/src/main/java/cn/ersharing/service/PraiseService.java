package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.PraiseRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.pojo.Praise;

public interface PraiseService {
    /**
     * 点赞
     * @param praiseRequestBody
     * @return
     */
    JsonResult addPraise(PraiseRequestBody praiseRequestBody);

    /**
     * 取消点赞
     * @param praiseRequestBody
     * @return
     */
    JsonResult cancelPraise(PraiseRequestBody praiseRequestBody);
}
