package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.InformRequestBody;
import cn.ersharing.common.ResponsePojo.HotResourceResult;
import cn.ersharing.common.ResponsePojo.MyInformResult;
import cn.ersharing.common.ResponsePojo.SearchResourcesDetail;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.EnterpriseMapper;
import cn.ersharing.mapper.InformMapper;
import cn.ersharing.mapper.PraiseMapper;
import cn.ersharing.mapper.ResourcesMapper;
import cn.ersharing.pojo.*;
import cn.ersharing.service.InformService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InformServiceImpl implements InformService {

    @Autowired
    private InformMapper informMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private PraiseMapper praiseMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonResult informEnterprise(InformRequestBody informRequestBody) {
        if (StringUtils.isNoneBlank(informRequestBody.getToken()) && StringUtils.isNoneBlank(informRequestBody.getEnterpriseFollowId().toString())){
            String json = jedisClient.get(USER_SESSION + ":" + informRequestBody.getToken());
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                if(enterprise.getEnterpriseId().equals(informRequestBody.getEnterpriseFollowId())){
                    return JsonResult.build(403,"不能关注自己");
                }
                Inform inform = new Inform();
                inform.setEnterpriseId(enterprise.getEnterpriseId());
                inform.setEnterpriseFollowid(informRequestBody.getEnterpriseFollowId());
                inform.setFollowTime(new Date());
                informMapper.insert(inform);
                return JsonResult.ok();
            }
        }
        return JsonResult.build(400,"用户未登录或关注的企业不存在");
    }

    @Override
    public JsonResult cancelInformEnterprise(InformRequestBody informRequestBody) {
        if (StringUtils.isNoneBlank(informRequestBody.getToken()) && StringUtils.isNoneBlank(informRequestBody.getEnterpriseFollowId().toString())){
            String json = jedisClient.get(USER_SESSION + ":" + informRequestBody.getToken());
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                InformExample example = new InformExample();
                example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId()).andEnterpriseFollowidEqualTo(informRequestBody.getEnterpriseFollowId());
                informMapper.deleteByExample(example);
                return JsonResult.ok();
            }
        }
        return JsonResult.build(400,"用户未登录或关注的企业不存在");
    }

    @Override
    public JsonResult myInform(String token) {
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                InformExample example = new InformExample();
                if (enterprise != null){
                    example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
                    List<Inform> informs = informMapper.selectByExample(example);
                    List<MyInformResult> informResults = new ArrayList<>();
                    for(Inform inform : informs){
                        MyInformResult result = new MyInformResult();
                        result.setInformId(inform.getInformId());
                        result.setEnterpriseFollowid(inform.getEnterpriseFollowid());
                        result.setEnterpriseId(inform.getEnterpriseId());
                        result.setFollowTime(inform.getFollowTime());
                        result.setEnterpriseName(enterprise.getEnterpriseName());
                        result.setEnterpriseLogo(enterprise.getEnterpriseLogo());
                        List<SearchResourcesDetail> resourcesDetails = resourcesMapper.selectResourcesByEnterpriseId(inform.getEnterpriseFollowid());
                        List<HotResourceResult> hotResourceResults = new ArrayList<>();
                        for(SearchResourcesDetail searchResourcesDetail : resourcesDetails){
                            Integer resourceId = searchResourcesDetail.getResourcesId();
                            String resourceScan = jedisClient.hget("SCAN_RESOURCE", resourceId.toString());
                            String resourceComment = jedisClient.hget("COMMENT", resourceId.toString());
                            String resourcePraise = jedisClient.hget("PRAISE", resourceId.toString());
                            HotResourceResult result2 = new HotResourceResult();
                            result2.setResourcesId(searchResourcesDetail.getResourcesId());
                            result2.setResourcesCategoryId(searchResourcesDetail.getResourcesCategoryId());
                            result2.setCategoryName(searchResourcesDetail.getCategoryName());
                            result2.setEnterpriseId(searchResourcesDetail.getEnterpriseId());
                            result2.setEnterpriseCity(searchResourcesDetail.getEnterpriseCity());
                            result2.setResourcesName(searchResourcesDetail.getResourcesName());
                            result2.setResourcesPrice(searchResourcesDetail.getResourcesPrice());
                            result2.setResourcesCreatetime(searchResourcesDetail.getResourcesCreatetime());
                            result2.setResourcesUpdatetime(searchResourcesDetail.getResourcesUpdatetime());
                            result2.setResourcesStatus(searchResourcesDetail.getResourcesStatus());
                            result2.setResourcesCount(searchResourcesDetail.getResourcesCount());
                            result2.setResourcesOperatetype(searchResourcesDetail.getResourcesOperatetype());
                            result2.setResourcesAgencyfee(searchResourcesDetail.getResourcesAgencyfee());
                            result2.setResourcesImage(searchResourcesDetail.getResourcesImage());
                            result2.setResourcesTransactiontime(searchResourcesDetail.getResourcesTransactiontime());
                            result2.setResourcesDesc(searchResourcesDetail.getResourcesDesc());
                            result2.setEnterpriseName(searchResourcesDetail.getEnterpriseName());
                            result2.setEnterpriseLogoUrl(searchResourcesDetail.getEnterpriseLogoUrl());
                            result2.setResourcesDescription(searchResourcesDetail.getResourcesDescription());
                            // 1用户点赞过该资源 0用户未点赞过该资源
                            int praise = 0;
                            PraiseExample praiseExample = new PraiseExample();
                            praiseExample.createCriteria().andResourceIdEqualTo(resourceId).andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
                            List<Praise> praises = praiseMapper.selectByExample(praiseExample);
                            if (praises.size() > 0 && praises != null){
                                        praise = 1;
                            }
                            result2.setPraise(praise);
                            if(StringUtils.isNoneBlank(resourceScan)){
                                result2.setScanTimes(Long.parseLong(resourceScan));
                            }else{
                                result2.setScanTimes(0L);
                            }
                            if(StringUtils.isNoneBlank(resourcePraise)){
                                result2.setPriaseTimes(Long.parseLong(resourcePraise));
                            }else{
                                result2.setPriaseTimes(0L);
                            }
                            if(StringUtils.isNoneBlank(resourceComment)){
                                result2.setCommentTimes(Long.parseLong(resourceComment));
                            }else{
                                result2.setCommentTimes(0L);
                            }
                            hotResourceResults.add(result2);
                        }
                        result.setResources(hotResourceResults);
                        informResults.add(result);
                    }
                    return JsonResult.ok(informResults);
                }
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public Integer enterpriseInformNums(Integer enterpriseId) {
        if (null != enterpriseId){
            InformExample example = new InformExample();
            example.createCriteria().andEnterpriseFollowidEqualTo(enterpriseId);
            int nums = informMapper.countByExample(example);
            return nums;
        }
        return null;
    }
}
