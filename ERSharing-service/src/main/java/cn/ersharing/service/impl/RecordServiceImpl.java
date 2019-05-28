package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.RecordRequestBody;
import cn.ersharing.common.ResponsePojo.RecordResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.RecordMapper;
import cn.ersharing.mapper.ResourcesMapper;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.Record;
import cn.ersharing.pojo.Resources;
import cn.ersharing.service.RecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonResult generateSharingRecord(RecordRequestBody recordRequestBody) {
        String token = recordRequestBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + recordRequestBody.getToken());
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                Resources resources = resourcesMapper.selectByPrimaryKey(recordRequestBody.getResourcesId());
                if(resources == null){
                    return JsonResult.build(403,"资源不存在");
                }
                //完成交易
                resources.setResourcesStatus(0);
                resources.setResourcesTransactiontime(resources.getResourcesTransactiontime() + 1);
                resourcesMapper.updateByPrimaryKeySelective(resources);
                Record record = new Record();
                record.setResourcesId(recordRequestBody.getResourcesId());
                record.setRecordResourcesNumber(recordRequestBody.getRecordResourcesNumber());
                record.setRecordResourceOperatetype(recordRequestBody.getRecordResourceOperatetype());
                record.setRecordPayment(recordRequestBody.getRecordPayment());
                record.setRecordTradetime(new Date());
                if (null != recordRequestBody.getSharingEnterpriseId()){
                    record.setSharingEnterpriseId(recordRequestBody.getSharingEnterpriseId());
                    record.setAcceptEnterpriseId(enterprise.getEnterpriseId());
                }else if (null != recordRequestBody.getAcceptEnterpriseId()){
                    record.setAcceptEnterpriseId(recordRequestBody.getAcceptEnterpriseId());
                    record.setSharingEnterpriseId(enterprise.getEnterpriseId());
                }
                recordMapper.insert(record);
                return  JsonResult.ok(record);
            }

        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult myRecord(String token) {
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)) {
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                Record record = recordMapper.myRecord(enterprise.getEnterpriseId());
                RecordResult recordResult = new RecordResult();
                recordResult.setRecordId(record.getRecordId());
                recordResult.setAcceptEnterpriseId(record.getAcceptEnterpriseId());
                recordResult.setSharingEnterpriseId(record.getSharingEnterpriseId());
                recordResult.setMyEnterpriseId(enterprise.getEnterpriseId());
                recordResult.setRecordPayment(record.getRecordPayment());
                recordResult.setRecordResourceOperatetype(record.getRecordResourceOperatetype());
                recordResult.setRecordResourcesNumber(record.getRecordResourcesNumber());
                recordResult.setResourcesId(record.getResourcesId());
                recordResult.setRecordTradetime(record.getRecordTradetime());
                return JsonResult.ok(recordResult);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }
}
