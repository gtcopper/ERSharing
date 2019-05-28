package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.FeedbackRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.FileUploadUtils;
import cn.ersharing.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;

/**
 *  用户反馈api
 * @author haojie
 * @date 2019/1/16
 */
@RestController
@RequestMapping("/api/feedback")
public class FeedbackApi {

    @Autowired (required = false)
    private FeedbackService feedbackService;

    @Autowired
    private HttpSession session;

    @Value("${FEEDBACK_IMAGE_LOCATION}")
    private String FEEDBACK_IMAGE_LOCATION;

    @RequestMapping(value = "/enterprise",method = RequestMethod.POST)
    public JsonResult enterpriseFeedback(FeedbackRequestBody feedbackRequestBody, MultipartFile feedbackImage){
        try {
            String feedbackImageUrl = null;
            if (feedbackImage != null) {
                feedbackImageUrl  = FileUploadUtils.executeUploadFile(feedbackImage, session, FEEDBACK_IMAGE_LOCATION);
            }
            JsonResult result = feedbackService.enterpriseFeedback(feedbackRequestBody, feedbackImageUrl);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(500,"服务器内部错误");
    }
}
