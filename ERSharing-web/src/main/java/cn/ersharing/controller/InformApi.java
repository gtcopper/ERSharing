package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.InformRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关注模块
 */
@RestController
@RequestMapping(value = "/api/inform")
public class InformApi {

    @Autowired(required = false)
    private InformService informService;

    /**
     * 关注
     * @param informRequestBody
     * @return
     */
    @RequestMapping(value = "/focus",method = RequestMethod.POST)
    public JsonResult focusEnterprise(InformRequestBody informRequestBody){
        JsonResult result = informService.informEnterprise(informRequestBody);
        return result;
    }

    /**
     * 取消关注
     * @param informRequestBody
     * @return
     */
    @RequestMapping(value = "/cancelFocus",method = RequestMethod.POST)
    public JsonResult cancelFocusEnterprise(InformRequestBody informRequestBody){
        JsonResult result = informService.cancelInformEnterprise(informRequestBody);
        return result;
    }

    /**
     * 我的关注
     * @param token
     * @return
     */
    @RequestMapping(value = "/myFocus",method = RequestMethod.POST)
    public JsonResult myFocus(String token){
        JsonResult result = informService.myInform(token);
        return result;
    }

}
