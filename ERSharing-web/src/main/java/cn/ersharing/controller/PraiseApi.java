package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.PraiseRequestBody;
import cn.ersharing.common.ResponsePojo.PraiseResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.pojo.Praise;
import cn.ersharing.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 * 点赞api
 */
@RestController
@RequestMapping("/api/praise")
public class PraiseApi {

    @Autowired(required = false)
    private PraiseService praiseService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonResult addPraise(PraiseRequestBody requestBody){
        JsonResult jsonResult = praiseService.addPraise(requestBody);
        return jsonResult;
    }


    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public JsonResult cancelPraise(PraiseRequestBody requestBody){
        JsonResult jsonResult = praiseService.cancelPraise(requestBody);
        return jsonResult;
    }

}
