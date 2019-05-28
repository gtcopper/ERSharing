package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.RecordRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.pojo.Record;

/**
 * 用户共享记录
 * @author haojie
 * @date 2019/1/18
 */
public interface RecordService {

    /**
     * 生成共享记录
     * @param recordRequestBody
     * @return
     */
    JsonResult generateSharingRecord(RecordRequestBody recordRequestBody);

    /**
     * 我的共享记录
     * @param token
     * @return
     */
    JsonResult myRecord(String token);

}
