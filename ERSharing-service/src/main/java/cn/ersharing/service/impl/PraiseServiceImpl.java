package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.PraiseRequestBody;
import cn.ersharing.common.ResponsePojo.PraiseResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.PraiseMapper;
import cn.ersharing.mapper.ResourcesMapper;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.Praise;
import cn.ersharing.pojo.PraiseExample;
import cn.ersharing.pojo.Resources;
import cn.ersharing.service.PraiseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseMapper praiseMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonResult addPraise(PraiseRequestBody praiseRequestBody) {
        String token = praiseRequestBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            Integer resourceId = praiseRequestBody.getResourceId();
            Resources resources = resourcesMapper.selectByPrimaryKey(resourceId);
            if (StringUtils.isNoneBlank(json) && resources != null){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                Praise praise = new Praise();
                praise.setEnterpriseId(enterprise.getEnterpriseId());
                praise.setResourceId(resourceId);
                praiseMapper.insert(praise);
                String nums = jedisClient.hget("PRAISE", resourceId.toString());
                PraiseResult result = new PraiseResult();
                result.setResourceId(resourceId);
                if (!StringUtils.isNoneBlank(nums)){
                    jedisClient.hset("PRAISE",resourceId.toString(),"1");
                    result.setPraiseNums(1);
                    return JsonResult.ok(result);
                }
                Integer praiseNums = Integer.parseInt(nums) + 1;
                jedisClient.hset("PRAISE",resourceId.toString(),praiseNums.toString());
                result.setPraiseNums(praiseNums);
                return JsonResult.ok(result);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult cancelPraise(PraiseRequestBody praiseRequestBody) {
        String token = praiseRequestBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            Integer resourceId = praiseRequestBody.getResourceId();
            Resources resources = resourcesMapper.selectByPrimaryKey(resourceId);
            if (StringUtils.isNoneBlank(json) && resources != null){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                PraiseExample example = new PraiseExample();
                example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId()).andResourceIdEqualTo(resourceId);
                praiseMapper.deleteByExample(example);
                String nums = jedisClient.hget("PRAISE", resourceId.toString());
                PraiseResult result = new PraiseResult();
                result.setResourceId(resourceId);
                Integer praiseNums = 0;
                if (Integer.parseInt(nums) < 1){
                    jedisClient.hset("PRAISE",resourceId.toString(),praiseNums.toString());
                    result.setPraiseNums(praiseNums);
                    return JsonResult.ok(result);
                }
                praiseNums = Integer.parseInt(nums) - 1;
                jedisClient.hset("PRAISE",resourceId.toString(),praiseNums.toString());
                result.setPraiseNums(praiseNums);
                return JsonResult.ok(result);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }
}
