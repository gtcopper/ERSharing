package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.FeedbackRequestBody;
import cn.ersharing.common.pojo.JsonResult;

/**
 * 用户service
 * @author haojie
 * @date 2018/1/15
 */
public interface FeedbackService {

    /**
     * 反馈信息主体信息和图片保存的url
     * @param feedbackRequestBody
     * @param feedbackImageUrl
     * @return
     */
    JsonResult enterpriseFeedback(FeedbackRequestBody feedbackRequestBody,String feedbackImageUrl);

    /**
     * 查询所有用户反馈
     * @return
     */
    JsonResult findAllFeedbacks(String token);
}
