package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.PublishResourceRequestBody;
import cn.ersharing.common.ResponsePojo.*;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.PraiseMapper;
import cn.ersharing.mapper.ResourcesCategoryMapper;
import cn.ersharing.mapper.ResourcesMapper;
import cn.ersharing.pojo.*;
import cn.ersharing.service.ResourcesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private ResourcesCategoryMapper resourcesCategoryMapper;

    @Autowired
    private PraiseMapper praiseMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonResult resources(Integer page, Integer rows,String token) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        List<SearchResourcesDetail> results  = resourcesMapper.selectResourcesDetails();
        ResourcesExample example = new ResourcesExample();
        int total = resourcesMapper.countByExample(example);
        List<HotResourceResult> hotResourceResults = new ArrayList<>();
        for(SearchResourcesDetail searchResourcesDetail : results){
            Integer resourceId = searchResourcesDetail.getResourcesId();
            String resourceScan = jedisClient.hget("SCAN_RESOURCE", resourceId.toString());
            String resourceComment = jedisClient.hget("COMMENT", resourceId.toString());
            String resourcePraise = jedisClient.hget("PRAISE", resourceId.toString());
            HotResourceResult result = new HotResourceResult();
            result.setResourcesId(searchResourcesDetail.getResourcesId());
            result.setResourcesCategoryId(searchResourcesDetail.getResourcesCategoryId());
            result.setCategoryName(searchResourcesDetail.getCategoryName());
            result.setEnterpriseId(searchResourcesDetail.getEnterpriseId());
            result.setEnterpriseCity(searchResourcesDetail.getEnterpriseCity());
            result.setResourcesName(searchResourcesDetail.getResourcesName());
            result.setResourcesPrice(searchResourcesDetail.getResourcesPrice());
            result.setResourcesCreatetime(searchResourcesDetail.getResourcesCreatetime());
            result.setResourcesUpdatetime(searchResourcesDetail.getResourcesUpdatetime());
            result.setResourcesStatus(searchResourcesDetail.getResourcesStatus());
            result.setResourcesCount(searchResourcesDetail.getResourcesCount());
            result.setResourcesOperatetype(searchResourcesDetail.getResourcesOperatetype());
            result.setResourcesAgencyfee(searchResourcesDetail.getResourcesAgencyfee());
            result.setResourcesImage(searchResourcesDetail.getResourcesImage());
            result.setResourcesTransactiontime(searchResourcesDetail.getResourcesTransactiontime());
            result.setResourcesDesc(searchResourcesDetail.getResourcesDesc());
            result.setEnterpriseName(searchResourcesDetail.getEnterpriseName());
            result.setEnterpriseLogoUrl(searchResourcesDetail.getEnterpriseLogoUrl());
            result.setResourcesDescription(searchResourcesDetail.getResourcesDescription());
            // 1用户点赞过该资源 0用户未点赞过该资源
            int praise = 0;
            if (StringUtils.isNoneBlank(token)) {
                String json = jedisClient.get(USER_SESSION + ":" + token);
                if (StringUtils.isNoneBlank(json)) {
                    Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                    PraiseExample praiseExample = new PraiseExample();
                    praiseExample.createCriteria().andResourceIdEqualTo(resourceId).andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
                    List<Praise> praises = praiseMapper.selectByExample(praiseExample);
                    if (praises.size() > 0 && praises != null){
                        praise = 1;
                    }
                }
            }
            result.setPraise(praise);
            if(StringUtils.isNoneBlank(resourceScan)){
                result.setScanTimes(Long.parseLong(resourceScan));
            }else{
                result.setScanTimes(0L);
            }
            if(StringUtils.isNoneBlank(resourcePraise)){
                result.setPriaseTimes(Long.parseLong(resourcePraise));
            }else{
                result.setPriaseTimes(0L);
            }
            if(StringUtils.isNoneBlank(resourceComment)){
                result.setCommentTimes(Long.parseLong(resourceComment));
            }else{
                result.setCommentTimes(0L);
            }
            hotResourceResults.add(result);
        }
        //取查询结果
        PageInfo<HotResourceResult> itemPageInfo = new PageInfo<>(hotResourceResults);
        SearchResult result = new SearchResult();
        result.setTotal(total);
        result.setRows(hotResourceResults);
        return JsonResult.ok(result);
    }

    @Override
    public JsonResult resourcesSlideShow() {
        List<SlideShowResponse> responseList = new ArrayList<>();
        SlideShowResponse response1 = new SlideShowResponse();
        response1.setImageUrl("images/resource/6199008581738_Desert.jpg");
        response1.setTitle("化学反应设备");
        response1.setDetailsUrl("https://www.baidu.com");
        SlideShowResponse response2 = new SlideShowResponse();
        response2.setImageUrl("images/resource/6199019354748_Hydrangeas.jpg");
        response2.setTitle("棉被加工仪");
        response2.setDetailsUrl("https://www.baidu.com");
        SlideShowResponse response3 = new SlideShowResponse();
        response3.setImageUrl("images/resource/6199025047760_Lighthouse.jpg");
        response3.setTitle("棉床");
        response3.setDetailsUrl("https://www.baidu.com");
        responseList.add(response1);
        responseList.add(response2);
        responseList.add(response3);
        SlidesShowResult result = new SlidesShowResult();
        result.setTotal(3);
        result.setRows(responseList);
        return JsonResult.ok(result);
    }

    /**
     * 按value值进行降序排序
     */
    public static class ScanTimesComparator implements Comparator<Map.Entry<String,Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    }

    @Override
    public JsonResult hotResources(Integer page, Integer rows,String token) {
        if (page < 1){
            return JsonResult.build(400,"页数不能小于1");
        }
        Long hotResourcesNums = jedisClient.hlen("SCAN_RESOURCE");
        //计算起始记录位置
        int location = (page - 1) * rows;
        long remainNums = hotResourcesNums - location ;
        Set<String> results = jedisClient.hkeys("SCAN_RESOURCE");
        Map<String,Integer> map = new TreeMap<>();
        List<HotResourceResult> hotResourceResults = new ArrayList<>();
        for (String resourceId :
                    results) {
                map.put(resourceId,Integer.parseInt(jedisClient.hget("SCAN_RESOURCE", resourceId)));
        }
        // map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        //排序
        Collections.sort(list,new ScanTimesComparator());

        for (int i = location;i < location + (remainNums < rows ? remainNums : rows); i++){
            String resourceId = list.get(i).getKey();
            String resourceScan = jedisClient.hget("SCAN_RESOURCE", resourceId);
            String resourceComment = jedisClient.hget("COMMENT", resourceId);
            String resourcePraise = jedisClient.hget("PRAISE", resourceId);
            String json = jedisClient.hget("RESOURCE", resourceId);
            SearchResourcesDetail searchResourcesDetail = JsonUtils.jsonToPojo(json, SearchResourcesDetail.class);
            HotResourceResult result = new HotResourceResult();
            result.setResourcesId(searchResourcesDetail.getResourcesId());
            result.setResourcesCategoryId(searchResourcesDetail.getResourcesCategoryId());
            result.setCategoryName(searchResourcesDetail.getCategoryName());
            result.setEnterpriseId(searchResourcesDetail.getEnterpriseId());
            result.setEnterpriseCity(searchResourcesDetail.getEnterpriseCity());
            result.setResourcesName(searchResourcesDetail.getResourcesName());
            result.setResourcesPrice(searchResourcesDetail.getResourcesPrice());
            result.setResourcesCreatetime(searchResourcesDetail.getResourcesCreatetime());
            result.setResourcesUpdatetime(searchResourcesDetail.getResourcesUpdatetime());
            result.setResourcesStatus(searchResourcesDetail.getResourcesStatus());
            result.setResourcesCount(searchResourcesDetail.getResourcesCount());
            result.setResourcesOperatetype(searchResourcesDetail.getResourcesOperatetype());
            result.setResourcesAgencyfee(searchResourcesDetail.getResourcesAgencyfee());
            result.setResourcesImage(searchResourcesDetail.getResourcesImage());
            result.setResourcesTransactiontime(searchResourcesDetail.getResourcesTransactiontime());
            result.setResourcesDesc(searchResourcesDetail.getResourcesDesc());
            result.setEnterpriseName(searchResourcesDetail.getEnterpriseName());
            result.setEnterpriseLogoUrl(searchResourcesDetail.getEnterpriseLogoUrl());
            result.setResourcesDescription(searchResourcesDetail.getResourcesDescription());
            // 1用户点赞过该资源 0用户未点赞过该资源
            int praise = 0;
            if (StringUtils.isNoneBlank(token)) {
                String json2 = jedisClient.get(USER_SESSION + ":" + token);
                if (StringUtils.isNoneBlank(json2)) {
                    Enterprise enterprise = JsonUtils.jsonToPojo(json2, Enterprise.class);
                    PraiseExample praiseExample = new PraiseExample();
                    praiseExample.createCriteria().andResourceIdEqualTo(Integer.parseInt(resourceId)).andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
                    List<Praise> praises = praiseMapper.selectByExample(praiseExample);
                    if (praises.size() > 0 && praises != null){
                        praise = 1;
                    }
                }
            }
            result.setPraise(praise);
            if(StringUtils.isNoneBlank(resourceScan)){
                result.setScanTimes(Long.parseLong(resourceScan));
            }else{
                result.setScanTimes(0L);
            }
            if(StringUtils.isNoneBlank(resourcePraise)){
                result.setPriaseTimes(Long.parseLong(resourcePraise));
            }else{
                result.setPriaseTimes(0L);
            }
            if(StringUtils.isNoneBlank(resourceComment)){
                result.setCommentTimes(Long.parseLong(resourceComment));
            }else{
                result.setCommentTimes(0L);
            }
            hotResourceResults.add(result);
        }
        SearchResult result = new SearchResult();
        result.setTotal(hotResourcesNums);
        result.setRows(hotResourceResults);
        return JsonResult.ok(result);
    }

    @Override
    public JsonResult publicResource(PublishResourceRequestBody publishResourceRequestBody, String resourceImageUrls) {
        String token = publishResourceRequestBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                if(null == enterprise.getEnterpriseName() || null == enterprise.getEnterpriseLicense()){
                    return JsonResult.build(400,"信息不完善,请完善企业信息再进行资源发布");
                }
                Resources resources = new Resources();
                resources.setResourcesName(publishResourceRequestBody.getResourcesName());
                resources.setResourcesDesc(publishResourceRequestBody.getResourcesDesc());
                resources.setResourcesCategoryId(publishResourceRequestBody.getResourcesCategoryId());
                resources.setResourcesPrice(publishResourceRequestBody.getResourcesPrice());
                //设置资源操作类型 '资源操作类型 0---请求资源  1---发布资源'
                resources.setResourcesOperatetype(publishResourceRequestBody.getResourcesOperatetype());
                resources.setEnterpriseId(enterprise.getEnterpriseId());
                resources.setResourcesCount(publishResourceRequestBody.getResourcesCount());
                //正常可交易
                resources.setResourcesStatus(1);
                //设置交易次数
                resources.setResourcesTransactiontime(0);
                resources.setEnterpriseCity(publishResourceRequestBody.getEnterpriseCity());
                resources.setResourcesImage(resourceImageUrls);
                resources.setResourcesCreatetime(new Date());
                resources.setResourcesUpdatetime(new Date());
                resources.setResourcesAgencyfee(publishResourceRequestBody.getResourcesAgencyfee());
                resourcesMapper.insert(resources);
                return JsonResult.ok(resources);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult findResourcesByResourceName(String resourceName, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<SearchResourceResult> resources = resourcesMapper.selectResourcesByLikeResourcesName(resourceName);
        resources.forEach((SearchResourceResult r) ->{
            String resource = jedisClient.hget("SCAN_RESOURCE", r.getResourcesId().toString());
            String resourceComment = jedisClient.hget("COMMENT", r.getResourcesId().toString());
            String resourcePraise = jedisClient.hget("PRAISE", r.getResourcesId().toString());
            Integer resourcesScanTimes = null;
            Integer resourceCommentTimes = null;
            Integer resourcePraiseTimes = null;
            if (resource != null && !"".equals(resource)){
                resourcesScanTimes = Integer.parseInt(resource);
                r.setScanTimes(resourcesScanTimes);
            }else{
                r.setScanTimes(0);
            }
            if (resourceComment != null && !"".equals(resourceComment)){
                resourceCommentTimes = Integer.parseInt(resourceComment);
                r.setCommentTimes(resourceCommentTimes);
            }else{
                r.setCommentTimes(0);
            }
            if (resourcePraise != null && !"".equals(resourcePraise)){
                resourcePraiseTimes =Integer.parseInt(resourcePraise);
                r.setPraiseTimes(resourcePraiseTimes);
            }else{
                r.setPraiseTimes(0);
            }

        });
        PageInfo<SearchResourceResult> pageInfo = new PageInfo<>(resources);
        SearchResult result = new SearchResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(resources);
        return JsonResult.ok(result);
    }

    @Override
    public JsonResult findResourcesByCityName(String cityName, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<SearchResourceResult> resources = resourcesMapper.selectResourcesByLikeCityName(cityName);
        resources.forEach((SearchResourceResult r) ->{
            String resource = jedisClient.hget("SCAN_RESOURCE", r.getResourcesId().toString());
            String resourceComment = jedisClient.hget("COMMENT", r.getResourcesId().toString());
            String resourcePraise = jedisClient.hget("PRAISE", r.getResourcesId().toString());
            Integer resourcesScanTimes = null;
            Integer resourceCommentTimes = null;
            Integer resourcePraiseTimes = null;
            if (resource != null && !"".equals(resource)){
                resourcesScanTimes = Integer.parseInt(resource);
                r.setScanTimes(resourcesScanTimes);
            }else{
                r.setScanTimes(0);
            }
            if (resourceComment != null && !"".equals(resourceComment)){
                resourceCommentTimes = Integer.parseInt(resourceComment);
                r.setCommentTimes(resourceCommentTimes);
            }else{
                r.setCommentTimes(0);
            }
            if (resourcePraise != null && !"".equals(resourcePraise)){
                resourcePraiseTimes =Integer.parseInt(resourcePraise);
                r.setPraiseTimes(resourcePraiseTimes);
            }else{
                r.setPraiseTimes(0);
            }

        });
        PageInfo<SearchResourceResult> pageInfo = new PageInfo<>(resources);
        SearchResult result = new SearchResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(resources);
        return JsonResult.ok(result);
    }

    @Override
    public JsonResult findResourcesDetail(Integer resourceId) {
        if (resourceId != null){
            //查询缓存中是否存在这个资源
            try {
                String resource = jedisClient.hget("RESOURCE", resourceId.toString());
                if (StringUtils.isNoneBlank(resource)){
                    SearchResourcesDetail resourcesDetail = JsonUtils.jsonToPojo(resource, SearchResourcesDetail.class);
                    String scanTimesString = jedisClient.hget("SCAN_RESOURCE", resourceId.toString());
                    if (!StringUtils.isNoneBlank(scanTimesString)){
                        jedisClient.hset("SCAN_RESOURCE",resourceId.toString(),"1");
                        return JsonResult.ok(resourcesDetail);
                    }
                    Integer scanTimes = Integer.parseInt(scanTimesString);
                    jedisClient.hset("SCAN_RESOURCE",resourceId.toString(),(scanTimes+1) + "");
                    return JsonResult.ok(resourcesDetail);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //查询数据库
            SearchResourcesDetail resourcesDetail = resourcesMapper.selectResourcesDetailById(resourceId);
            try {
                jedisClient.hset("RESOURCE", resourceId.toString(),JsonUtils.objectToJson(resourcesDetail));
                jedisClient.hset("SCAN_RESOURCE",resourceId.toString(),"1");
            }catch (Exception e){
                e.printStackTrace();
            }
            return JsonResult.ok(resourcesDetail);
        }
        return JsonResult.build(400,"资源id不能为空");
    }

    @Override
    public JsonResult findResourceCategory() {
        ResourcesCategoryExample example = new ResourcesCategoryExample();
        List<ResourcesCategory> resourcesCategories = resourcesCategoryMapper.selectByExampleWithBLOBs(example);
        return JsonResult.ok(resourcesCategories);
    }

    @Override
    public JsonResult deleteResource(String token, Integer resourceId) {
        String json = jedisClient.get(USER_SESSION + ":" + token);
        if (null == resourceId){
            return JsonResult.build(400,"资源id不能为空");
        }
        if (StringUtils.isNoneBlank(json)){
            Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
            Resources resources = resourcesMapper.selectByPrimaryKey(resourceId);
            if (enterprise.getEnterpriseId().equals(resources.getEnterpriseId())){
                resources.setResourcesStatus(-1);
                resourcesMapper.updateByPrimaryKeySelective(resources);
                return JsonResult.ok("删除资源成功");
            }
            return JsonResult.build(400,"资源不是当前用户发布的无法删除");
        }
        return JsonResult.build(400,"用户未登录");
    }

}
