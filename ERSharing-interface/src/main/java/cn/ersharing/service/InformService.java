package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.InformRequestBody;
import cn.ersharing.common.pojo.JsonResult;

/**
 * 关注service
 * @author haojie
 * @date 2019/1/16d
 */
public interface InformService {

    /**
     * 关注
     * @param informRequestBody
     * @return
     */
    JsonResult informEnterprise(InformRequestBody informRequestBody);

    /**
     * 取消关注
     * @param informRequestBody
     * @return
     */
    JsonResult cancelInformEnterprise(InformRequestBody informRequestBody);

    /**
     * 我的关注
     * @param token
     * @return
     */
    JsonResult myInform(String token);

    /**
     * 企业的关注数
     * @param enterpriseId
     * @return
     */
    Integer enterpriseInformNums(Integer enterpriseId);

}
