package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.PublishResourceRequestBody;
import cn.ersharing.common.pojo.JsonResult;

/**
 * 资源service
 * @author haojie
 * @date 2019/1/17
 */
public interface ResourcesService {

    /**
     * 查询资源列表
     * @param page
     * @param rows
     * @return
     */
    JsonResult resources(Integer page,Integer rows,String token);

    /**
     * 资源轮播图
     * @return
     */
    JsonResult resourcesSlideShow();

    /**
     *
     * @param page
     * @param rows
     * @return
     */
    JsonResult hotResources(Integer page,Integer rows,String token);

    /**
     * 发布资源
     * @param publishResourceRequestBody
     * @param resourceImageUrls
     * @return
     */
    JsonResult publicResource(PublishResourceRequestBody publishResourceRequestBody,String resourceImageUrls);


    /**
     * 分页通过资源名模糊查询
     * @param resourceName
     * @param page
     * @param rows
     * @return
     */
    JsonResult findResourcesByResourceName(String resourceName,Integer page,Integer rows);

    /**
     * 分页通过城市名查询企业
     * @param cityName
     * @param page
     * @param rows
     * @return
     */
    JsonResult findResourcesByCityName(String cityName,Integer page,Integer rows);

    /**
     * 资源id查询资源详情
     * @param resourceId
     * @return
     */
    JsonResult findResourcesDetail(Integer resourceId);

    /**
     * 查看资源分类
     * @return
     */
    JsonResult findResourceCategory();

    /**
     * 删除资源(假删，设置状态为不可共享)
     * @param token
     * @param resourceId
     * @return
     */
    JsonResult deleteResource(String token,Integer resourceId);

}
