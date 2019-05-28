package cn.ersharing.controller;

import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.service.EnterpriseService;
import cn.ersharing.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/search")
public class SearchApi {

    @Autowired(required = false)
    private ResourcesService resourcesService;

    @Autowired(required = false)
    private EnterpriseService enterpriseService;

    /**
     * 企业名模糊查询企业(分页)
     * @param enterpriseName
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/enterprise/enterpriseName",method = POST)
    public JsonResult searchEnterpriseByName(String enterpriseName,Integer page,Integer rows){
        JsonResult result = enterpriseService.findEnterpriseByEnterpriseName(enterpriseName,page,rows);
        return result;
    }

    /**
     * 城市名模糊查询企业(分页)
     * @param cityName
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/enterprise/cityName",method = POST)
    public JsonResult searchEnterpriseByCityName(String cityName,
                                                 @RequestParam(value = "page",defaultValue = "1") Integer page ,Integer rows){
        JsonResult result = enterpriseService.findEnterpriseByCityName(cityName,page,rows);
        return result;
    }

    /**
     * 资源名查找资源(模糊分页查询)
     * @param resourceName 资源名
     * @return
     */
    @RequestMapping(value = "/resource/resourceName",method = POST)
    public JsonResult searchByKeyResourceName(String resourceName,
                                      @RequestParam(value = "page",defaultValue = "1") Integer page ,Integer rows) {
        JsonResult result = resourcesService.findResourcesByResourceName(resourceName, page, rows);
        return result;
    }

    /**
     *  城市名查找资源(模糊分页查询)
     * @param cityName
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/resource/cityName",method = POST)
    public JsonResult searchByCityName(String cityName,
                                      @RequestParam(value = "page",defaultValue = "1") Integer page ,Integer rows) {
        JsonResult result = resourcesService.findResourcesByCityName(cityName, page, rows);
        return result;
    }

}
