package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.*;
import cn.ersharing.common.ResponsePojo.EnterpriseInformationResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.EnterpriseAddress;
import cn.ersharing.pojo.Inform;

import java.util.Map;

public interface EnterpriseService {
    /**
     * 注册用户
     */

    JsonResult registerAccount(RegisterBody registerBody);

    /**
     * 登录
     * @param loginBody
     * @return
     */
    JsonResult login(LoginBody loginBody);


    /**
     * 通过手机号发送验证码
     * @param phone
     * @return
     */
    JsonResult sendCode(String phone);

    /**
     * 判断手机号是否存在
     * @return
     */
    boolean checkPhoneExist(String phone);

    /**
     * 判断邮箱是否存在
     * @return
     */
    boolean checkEmailExist(String email);

    /**
     *  判断用户名是否存在
     * @param enterprise_user
     * @return
     */
    boolean checkEnterpriseUserExist(String enterprise_user);

    /**
     * 查找企业名是否存在
     * @param enterpriseName
     * @return
     */
    boolean checkEnterpriseNameExist(String enterpriseName);

    /**
     * 通过token查找企业
     * @param token
     * @return
     */
    Enterprise findEnterpriseByToken(String token);

    /**
     * 通过企业id查询企业详细信息(含有token结果集包含是否关注)
     * @param enterpriseId
     * @return
     */
    JsonResult findEnterpriseById(String token, Integer enterpriseId);

    /**
     * 通过企业id查询企业地址
     * @param enterpriseId
     * @return
     */
    EnterpriseAddress findEnterpriseAddressById(Integer enterpriseId);

    /**
     * 通过企业名查找企业
     * @param enterpriseName
     * @return
     */
    JsonResult findEnterpriseByEnterpriseName(String enterpriseName,Integer page,Integer rows);

    /**
     * 通过城市名查找
     * @param cityName
     * @return
     */
    JsonResult findEnterpriseByCityName(String cityName,Integer page,Integer rows);

    /**
     * 登出
     * @param token
     * @return
     */
    JsonResult logout(String token);

    /**
     * 企业信息
     * @param token
     * @return
     */
    JsonResult enterpriseInfo(String token);

    /**
     * 完善表单数据
     * @return
     */
    JsonResult completeEnterpriseInfo(CompleteEnterpriseInfoBody completeEnterpriseInfoBody,String enterpriseLicenseUrl,String enterpriseLogoUrl);

    /**
     * 更新企业信息
     * @param updateEnterpriseBody
     * @param
     * @return
     */
    JsonResult updateEnterpriseInfo(UpdateEnterpriseBody updateEnterpriseBody,String enterpriseLicenseUrl,String enterpriseLogoUrl);

    /**
     * 企业修改手机号,发送短信验证
     * @param updateEnterprisePhoneBody
     * @return
     */
    JsonResult updateEnterprisePhone(UpdateEnterprisePhoneBody updateEnterprisePhoneBody);

    /**
     *  修改企业密码
     * @param updateEnterprisePasswordBody
     * @return
     */
    JsonResult updateEnterprisePassword(UpdateEnterprisePasswordBody updateEnterprisePasswordBody);

    /**
     * 企业用户忘记密码
     * @param forgetPasswordBody
     * @return
     */
    JsonResult forgetEnterprisePassword(ForgetPasswordBody forgetPasswordBody);

    /**
     * 查找企业地址列表
     */
    JsonResult findEnterpriseAddress(String token);

}
