package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.PublishResourceRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.FileUploadUtils;
import cn.ersharing.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 资源模块
 *
 */
@RestController
@RequestMapping(value = "/api/resource")
public class ResourceApi {

    @Autowired(required = false)
    private ResourcesService resourcesService;

    @Autowired
    private HttpSession session;

    @Value("${FILE_RESOURCE_LOCATION}")
    private String FILE_RESOURCE_LOCATION;

    /**
     * 资源列表
     * @return
     */
    @RequestMapping(value = "/resources", method = GET)
    public JsonResult resources( @RequestParam(value = "page",defaultValue = "1") Integer page ,
                                 Integer rows,@RequestParam(value = "token",defaultValue = "") String token) {
        JsonResult result = resourcesService.resources(page,rows,token);
        return result;
    }


    /**
     * 资源分类列表
     *
     * @return
     */
    @RequestMapping(value = "/resourceClassList", method = GET)
    public JsonResult resourceClazzList() {
        JsonResult result = resourcesService.findResourceCategory();
        return result;
    }

    /**
     * 轮播图请求
     * @return
     */
    //@CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/slideshow", method = GET)
    public JsonResult resourceSlideShow() {
        JsonResult result = resourcesService.resourcesSlideShow();
        return result;
    }

    @RequestMapping(value = "/hotResources",method = GET)
    public JsonResult hotResources(@RequestParam(value = "page",defaultValue = "1") Integer page ,
                                    Integer rows,@RequestParam(value = "token",defaultValue = "") String token){
        JsonResult result = resourcesService.hotResources(page,rows,token);
        return result;
    }

    /**
     * 资源详情
     *
     * @param resourceId 资源id
     * @return
     */
    @RequestMapping(value = "/resourceDetail/{resourceId}", method = GET)
    public JsonResult resourceDetail(@PathVariable("resourceId") Integer resourceId) {
        JsonResult resourcesDetail = resourcesService.findResourcesDetail(resourceId);
        return resourcesDetail;
    }


    /**
     * 发布资源
     * @param resourceRequestBody
     * @param resourceImages
     * @return
     */
    @RequestMapping(value = "/enterprise/publishResource", method = POST)
    public JsonResult publishResource(PublishResourceRequestBody resourceRequestBody, @RequestParam(value = "resourceImages") MultipartFile[] resourceImages) {
        try {
            if (resourceRequestBody.getResourcesOperatetype() > 1 || resourceRequestBody.getResourcesOperatetype() < 0){
                return JsonResult.build(400,"操作类型异常，请输入1 发布资源，0 需求资源");
            }
            if (null == resourceImages && resourceRequestBody.getResourcesOperatetype() == 0){
                JsonResult result = resourcesService.publicResource(resourceRequestBody, null);
                return JsonResult.ok(result);
            }else if (null == resourceImages && resourceRequestBody.getResourcesOperatetype() == 1){
                return JsonResult.build(400,"发布资源图片不能为空");
            }
            String resourceImageUrls = "";
            for (int i = 0; i < resourceImages.length; i++) {
                if (i == resourceImages.length -1){
                    resourceImageUrls += FileUploadUtils.executeUploadFile(resourceImages[i],session,FILE_RESOURCE_LOCATION);
                    break;
                }
                resourceImageUrls += FileUploadUtils.executeUploadFile(resourceImages[i],session,FILE_RESOURCE_LOCATION) + ",";
            }
            JsonResult result = resourcesService.publicResource(resourceRequestBody, resourceImageUrls);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(500,"服务器内部错误");
    }

    /**
     * 修改资源信息
     *
     * @param token 用户令牌
     * @return
     */
    @RequestMapping(value = "/enterprise/updateResource", method = GET)
    public JsonResult updateResource(@RequestParam("resourceId") Integer resourceId, @RequestParam("token") String token, HttpServletRequest request) {
        return null;
    }

    /**
     * 删除资源
     *
     * @param token 用户令牌
     * @return
     */
    @RequestMapping(value = "/enterprise/deleteResource", method = POST)
    public JsonResult deleteResource(@RequestParam Integer resourceId, @RequestParam("token") String token) {
        JsonResult result = resourcesService.deleteResource(token, resourceId);
        return result;
    }
}
