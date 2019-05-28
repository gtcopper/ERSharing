package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.FeedbackRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.FeedbackMapper;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.Feedback;
import cn.ersharing.pojo.FeedbackExample;
import cn.ersharing.service.FeedbackService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired(required = false)
    private FeedbackMapper feedbackMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${MANAGER_SESSION}")
    private String MANAGER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonResult enterpriseFeedback(FeedbackRequestBody feedbackRequestBody, String feedbackImageUrl) {

        String json = jedisClient.get(USER_SESSION + ":" + feedbackRequestBody.getToken());
        if (StringUtils.isNoneBlank(json)){
            Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
            Feedback feedback = new Feedback();
            if (feedbackRequestBody.getAnonmity() == 0){
                feedback.setAnonmity(feedbackRequestBody.getAnonmity());
            }else{
                feedback.setEnterpriseId(enterprise.getEnterpriseId());
                feedback.setAnonmity(feedbackRequestBody.getAnonmity());
            }
            feedback.setFeedbackText(feedbackRequestBody.getFeedbackText());
            feedback.setFeedbackImage(feedbackImageUrl);
            feedbackMapper.insert(feedback);
            jedisClient.expire(USER_SESSION + ":" + feedbackRequestBody.getToken(),SESSION_EXPIRE);
            return JsonResult.ok();

        }
        return JsonResult.build(400,"用户未登录");
    }


    @Override
    public JsonResult findAllFeedbacks(String token) {
        String json = jedisClient.get(MANAGER_SESSION + ":" + token);
        if (!StringUtils.isNoneBlank(json)){
            return JsonResult.build(400,"不是管理员，权限不足无法查看");
        }
        FeedbackExample example = new FeedbackExample();
        List<Feedback> feedbacks = feedbackMapper.selectByExample(example);
        jedisClient.expire(MANAGER_SESSION + ":" + token,SESSION_EXPIRE);
        return JsonResult.ok(feedbacks);
    }
}
