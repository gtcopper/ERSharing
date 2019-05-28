package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.ManagerLoginBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.service.FeedbackService;
import cn.ersharing.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员api
 * @author haojie
 * @date 2019/1/16
 */
@RestController
@RequestMapping("/api/manager")
public class ManagerApi {

    @Autowired (required = false)
    private ManagerService managerService;

    @Autowired (required = false)
    private FeedbackService feedbackService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult loginManager(ManagerLoginBody managerLoginBody){
        JsonResult result = managerService.loginManager(managerLoginBody);
        return result;
    }

    @RequestMapping(value = "/feedbacks",method = RequestMethod.GET)
    public JsonResult findFeedbacks(String token){
        JsonResult feedbacks = feedbackService.findAllFeedbacks(token);
        return feedbacks;
    }

}
