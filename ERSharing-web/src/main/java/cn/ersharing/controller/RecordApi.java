package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.RecordRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 记录、操作模块
 */
@RestController
@RequestMapping(value = "/api/record")
public class RecordApi {

    @Autowired(required = false)
    private RecordService recordService;

    @RequestMapping(value = "/resource/generateRecord",method = POST)
    public JsonResult generateRecord(RecordRequestBody recordRequestBody){
        JsonResult result = recordService.generateSharingRecord(recordRequestBody);
        return result;
    }

    /**
     * 用户共享记录
     * @param token
     * @return
     */
    @RequestMapping(value = "/enterprise/shareResourceRecord", method = POST)
    public JsonResult shareResourceRecord(String token) {
        JsonResult result = recordService.myRecord(token);
        return result;
    }



}
