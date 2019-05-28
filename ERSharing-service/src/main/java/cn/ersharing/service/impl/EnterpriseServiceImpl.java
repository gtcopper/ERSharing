package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.*;
import cn.ersharing.common.ResponsePojo.*;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.*;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.EnterpriseAddressMapper;
import cn.ersharing.mapper.EnterpriseMapper;
import cn.ersharing.mapper.InformMapper;
import cn.ersharing.pojo.*;
import cn.ersharing.service.EnterpriseService;
import cn.ersharing.service.InformService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 企业模块service
 * @author haojie
 * @date 2019/1/09
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private EnterpriseAddressMapper enterpriseAddressMapper;

    @Autowired
    private InformMapper informMapper;

    @Autowired(required = false)
    private InformService informService;

    /**
     * 注入jedisClient
     */
    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private HttpSession session;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Value("${SUCCESS_CODE_VALUE}")
    private String SUCCESS_CODE_VALUE;

    @Value("${CODE}")
    private String CODE;

    @Value("${OK}")
    private String OK;

    @Override
    public JsonResult registerAccount(RegisterBody registerBody) {
        String enterprise_user = registerBody.getEnterprise_user();
        String phone = registerBody.getPhone();
        String password = registerBody.getPassword();
        String checkCode = registerBody.getCheckCode();
        if (!checkPhoneExist(phone)) {
                if (!checkEnterpriseUserExist(enterprise_user)) {
                    if (!"".equals(password) && null != password) {
                        if (StringUtils.isNoneBlank(checkCode)) {
                            //判断短信
                            try {
                                if (Integer.parseInt(SUCCESS_CODE_VALUE) == MessageApi.setVerifySmsCode(phone, checkCode)) {
                                    Enterprise enterprise = new Enterprise();
                                    enterprise.setEnterpriseUser(enterprise_user);
                                    enterprise.setEnterprisePhone(phone);
                                    enterprise.setEnterprisePassword(MD5.generateMD5(password));
                                    //更新数据库
                                    enterpriseMapper.insertSelective(enterprise);
                                    //设置json返回值
                                    registerBody.setPassword(null);
                                    registerBody.setCheckCode(null);
                                    return JsonResult.ok(registerBody);
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            return JsonResult.build(400,"验证码错误");
                        }
                    }
                    return JsonResult.build(400, "密码不能为空");
                }
                return JsonResult.build(400, "用户名已存在");
            }
            return JsonResult.build(400, "手机号已存在");
        }

    @Override
    public JsonResult login(LoginBody loginBody) {
        String phone = loginBody.getPhone();
        String password = loginBody.getPassword();
        if (StringUtils.isNoneBlank(password) && StringUtils.isNoneBlank(phone)){
            EnterpriseExample example = new EnterpriseExample();
            example.createCriteria().andEnterprisePhoneEqualTo(phone);
            List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
            if (null != enterprises && enterprises.size() > 0){
                Enterprise enterprise = enterprises.get(0);
                if (enterprise.getEnterprisePassword().equals(MD5.generateMD5(password))){
                    //设置json返回值
                    TokenResult tokenResult = new TokenResult();
                    //生成token。用户唯一标识
                    String token = MD5.generateMD5(enterprise.getEnterpriseId() + "" + System.currentTimeMillis());
                    tokenResult.setToken(token);
                    tokenResult.setEnterprise_user(enterprise.getEnterpriseUser());
                    tokenResult.setPhone(enterprise.getEnterprisePhone());
                    tokenResult.setEnterpriseId(enterprise.getEnterpriseId());
                    if(enterprise.getEnterpriseLogo() == null){
                        tokenResult.setEnterpriseLogo("");
                    }else{
                        tokenResult.setEnterpriseLogo(enterprise.getEnterpriseLogo());
                    }
                    //设置redis缓存用户token信息
                    jedisClient.set(USER_SESSION + ":" + token,JsonUtils.objectToJson(enterprise));
                    jedisClient.expire(USER_SESSION + ":" + token,SESSION_EXPIRE);
                    return JsonResult.ok(tokenResult);
                }
                return JsonResult.build(400,"用户名或密码错误");
            }
            return JsonResult.build(400,"手机号不存在");
        }
        return JsonResult.build(400,"手机号或密码不能为空");
    }

    /**
     * 生产环境
     * @param phone
     * @return
     */
    @Override
    public JsonResult sendCode(String phone) {
        try{
            String message = MessageApi.setRequestSmsCode(phone);
            if (OK.equals(message)){
                return JsonResult.ok();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(400,"短信不可用");
    }

    @Override
    public boolean checkPhoneExist(String phone) {
        EnterpriseExample example = new EnterpriseExample();
        example.createCriteria().andEnterprisePhoneEqualTo(phone);
        List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
        if (enterprises != null && enterprises.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmailExist(String email) {
        EnterpriseExample example = new EnterpriseExample();
        example.createCriteria().andEnterpriseEmailEqualTo(email);
        List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
        if (enterprises != null && enterprises.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEnterpriseUserExist(String enterprise_user) {
        if (StringUtils.isNoneBlank(enterprise_user)){
            EnterpriseExample example = new EnterpriseExample();
            example.createCriteria().andEnterpriseUserEqualTo(enterprise_user);
            List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
            if (null != enterprises && enterprises.size() > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkEnterpriseNameExist(String enterpriseName) {
        if (StringUtils.isNoneBlank(enterpriseName)){
            EnterpriseExample example = new EnterpriseExample();
            example.createCriteria().andEnterpriseNameEqualTo(enterpriseName);
            List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
            if (null != enterprises && enterprises.size() > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public Enterprise findEnterpriseByToken(String token) {
        String json = jedisClient.get(USER_SESSION + ":" + token);
        if (StringUtils.isNoneBlank(json)){
            Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
            return enterprise;
        }
        return null;
    }

    @Override
    public JsonResult findEnterpriseById(String token, Integer enterpriseId) {
        if (enterpriseId != null){
            Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(enterpriseId);
            if (null != enterprise){
                EnterpriseAddress enterpriseAddress = findEnterpriseAddressById(enterpriseId);
                Integer nums = informService.enterpriseInformNums(enterpriseId);
                if (null != enterprise && null != enterpriseAddress && nums != null){
                    EnterpriseInformationResult result = new EnterpriseInformationResult();
                    result.setEnterpriseId(enterpriseId);
                    result.setEnterpriseLegalrepresentative(enterprise.getEnterpriseLegalrepresentative());
                    result.setEnterpriseAddress(enterprise.getEnterpriseAddress());
                    result.setEnterpriseName(enterprise.getEnterpriseName());
                    result.setEnterpriseLogoUrl(enterprise.getEnterpriseLogo());
                    result.setEnterpriseLicenseUrl(enterprise.getEnterpriseLicense());
                    result.setEnterpriseProvince(enterpriseAddress.getEnterpriseProvince());
                    result.setEnterpriseCity(enterpriseAddress.getEnterpriseCity());
                    result.setInformNums(nums);
                    if (StringUtils.isNoneBlank(token)){
                        String json = jedisClient.get(USER_SESSION + ":" + token);
                        if (StringUtils.isNoneBlank(json)) {
                            Enterprise myEnterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                            InformExample example = new InformExample();
                            example.createCriteria().andEnterpriseFollowidEqualTo(enterpriseId).andEnterpriseIdEqualTo(myEnterprise.getEnterpriseId());
                            List<Inform> informs = informMapper.selectByExample(example);
                            if (null != informs && informs.size() > 0){
                                //是否关注 1 关注 0 未关注
                                result.setFocus(1);
                            }else{
                                result.setFocus(0);
                            }
                        }
                    }
                    return JsonResult.ok(result);
                }
                return JsonResult.build(400,"该id的企业不存在");
            }

        }
        return JsonResult.build(400,"该id的企业不存在");
    }

    @Override
    public EnterpriseAddress findEnterpriseAddressById(Integer enterpriseId) {
        if (null != enterpriseId){
            EnterpriseAddressExample example = new EnterpriseAddressExample();
            example.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
            List<EnterpriseAddress> enterpriseAddresses = enterpriseAddressMapper.selectByExample(example);
            if (enterpriseAddresses != null && enterpriseAddresses.size() > 0){
                return enterpriseAddresses.get(0);
            }
        }
        return null;
    }

    @Override
    public JsonResult findEnterpriseByEnterpriseName(String enterpriseName,Integer page,Integer rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        //执行查询
        List<EnterpriseInfoResult> enterprises = enterpriseMapper.selectEnterpriseByLikeEnterpriseName(enterpriseName);
        //取查询结果
        PageInfo<EnterpriseInfoResult> itemPageInfo = new PageInfo<>(enterprises);
        SearchResult result = new SearchResult();
        result.setTotal(itemPageInfo.getTotal());
        result.setRows(enterprises);
        return JsonResult.ok(result);
    }

    @Override
    public JsonResult findEnterpriseByCityName(String cityName,Integer page,Integer rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        List<EnterpriseInfoResult> results = enterpriseMapper.selectEnterpriseByLikeCityName(cityName);
        //取查询结果
        PageInfo<EnterpriseInfoResult> itemPageInfo = new PageInfo<>(results);
        SearchResult result = new SearchResult();
        result.setTotal(itemPageInfo.getTotal());
        result.setRows(results);
        return JsonResult.ok(result);
    }

    @Override
    public JsonResult logout(String token) {
        String json = jedisClient.get(USER_SESSION + ":" + token);
        if (StringUtils.isNoneBlank(json)){
            jedisClient.expire(USER_SESSION + ":" + token,0);
            return JsonResult.build(200,"退出登录成功");
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult completeEnterpriseInfo(CompleteEnterpriseInfoBody completeEnterpriseInfoBody, String enterpriseLicenseUrl, String enterpriseLogoUrl) {
        String token = completeEnterpriseInfoBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                enterprise.setEnterpriseAddress(completeEnterpriseInfoBody.getEnterpriseAddress());
                if (checkEmailExist(completeEnterpriseInfoBody.getEnterpriseEmail())){
                    return JsonResult.build(400,"邮箱已被使用");
                }
                enterprise.setEnterpriseEmail(completeEnterpriseInfoBody.getEnterpriseEmail());
                enterprise.setEnterpriseLegalrepresentative(completeEnterpriseInfoBody.getEnterpriseLegalrepresentative());
                enterprise.setEnterpriseLicense(enterpriseLicenseUrl);
                enterprise.setEnterpriseLogo(enterpriseLogoUrl);
                if (checkEnterpriseNameExist(completeEnterpriseInfoBody.getEnterpriseName())){
                    return JsonResult.build(400,"企业已经被注册");
                }
                enterprise.setEnterpriseName(completeEnterpriseInfoBody.getEnterpriseName());
                //企业信息修改，插入数据库
                enterpriseMapper.updateByPrimaryKeySelective(enterprise);
                //更新redis数据信息
                jedisClient.set(USER_SESSION + ":" + token,JsonUtils.objectToJson(enterprise));
                //修改token时长
                jedisClient.expire(USER_SESSION + ":" + token,SESSION_EXPIRE);
                //设置地址信息
                EnterpriseAddress enterpriseAddress = new EnterpriseAddress();
                enterpriseAddress.setEnterpriseId(enterprise.getEnterpriseId());
                enterpriseAddress.setEnterpriseAddress(enterprise.getEnterpriseAddress());
                enterpriseAddress.setEnterpriseProvince(completeEnterpriseInfoBody.getEnterpriseProvince());
                enterpriseAddress.setEnterpriseCity(completeEnterpriseInfoBody.getEnterpriseCity());
                //插入地址信息到数据库
                enterpriseAddressMapper.insert(enterpriseAddress);
                //返回json结果
                CompleteEnterpriseInfoResultBody completeEnterpriseInfoResultBody = new CompleteEnterpriseInfoResultBody();
                completeEnterpriseInfoResultBody.setToken(token);
                completeEnterpriseInfoResultBody.setEnterpriseId(enterprise.getEnterpriseId());
                completeEnterpriseInfoResultBody.setEnterpriseName(completeEnterpriseInfoBody.getEnterpriseName());
                completeEnterpriseInfoResultBody.setEnterpriseEmail(completeEnterpriseInfoBody.getEnterpriseEmail());
                completeEnterpriseInfoResultBody.setEnterpriseLegalrepresentative(completeEnterpriseInfoBody.getEnterpriseLegalrepresentative());
                completeEnterpriseInfoResultBody.setEnterpriseAddress(completeEnterpriseInfoBody.getEnterpriseAddress());
                completeEnterpriseInfoResultBody.setEnterpriseProvince(completeEnterpriseInfoBody.getEnterpriseProvince());
                completeEnterpriseInfoResultBody.setEnterpriseCity(completeEnterpriseInfoBody.getEnterpriseCity());
                completeEnterpriseInfoResultBody.setEnterpriseLicenseUrl(enterpriseLicenseUrl);
                completeEnterpriseInfoResultBody.setEnterpriseLogoUrl(enterpriseLogoUrl);
                return JsonResult.ok(completeEnterpriseInfoResultBody);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult enterpriseInfo(String token) {
        Enterprise enterprise = findEnterpriseByToken(token);
        if (enterprise != null){
            EnterpriseInfoResult enterpriseInfoResult = new EnterpriseInfoResult();
            EnterpriseAddressExample example = new EnterpriseAddressExample();
            example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
            List<EnterpriseAddress> enterpriseAddresses = enterpriseAddressMapper.selectByExample(example);
            EnterpriseAddress enterpriseAddress;
            if (null != enterpriseAddresses && enterpriseAddresses.size() > 0){
                enterpriseAddress = enterpriseAddresses.get(0);
                enterpriseInfoResult.setEnterpriseProvince(enterpriseAddress.getEnterpriseProvince());
                enterpriseInfoResult.setEnterpriseCity(enterpriseAddress.getEnterpriseCity());
            }
            //设置json返回值
            enterpriseInfoResult.setToken(token);
            enterpriseInfoResult.setEnterpriseId(enterprise.getEnterpriseId());
            enterpriseInfoResult.setEnterpriseName(enterprise.getEnterpriseName());
            enterpriseInfoResult.setEnterpriseUser(enterprise.getEnterpriseUser());
            enterpriseInfoResult.setPhone(enterprise.getEnterprisePhone());
            enterpriseInfoResult.setEnterpriseAddress(enterprise.getEnterpriseAddress());
            enterpriseInfoResult.setEnterpriseEmail(enterprise.getEnterpriseEmail());
            enterpriseInfoResult.setEnterpriseLicenseUrl(enterprise.getEnterpriseLicense());
            enterpriseInfoResult.setEnterpriseLogoUrl(enterprise.getEnterpriseLogo());
            enterpriseInfoResult.setEnterpriseLegalrepresentative(enterprise.getEnterpriseLegalrepresentative());
            return JsonResult.ok(enterpriseInfoResult);
        }
        return JsonResult.build(400,"企业不存在");
    }


    @Override
    public JsonResult updateEnterpriseInfo(UpdateEnterpriseBody updateEnterpriseBody,String enterpriseLicenseUrl,String enterpriseLogoUrl) {
        String token = updateEnterpriseBody.getToken();
        if (StringUtils.isNoneBlank(token)) {
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)) {
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                //设置修改的属性
                if (checkEnterpriseNameExist(updateEnterpriseBody.getEnterpriseName())){
                    return JsonResult.build(400,"企业已经被注册");
                }
                enterprise.setEnterpriseName(updateEnterpriseBody.getEnterpriseName());
                enterprise.setEnterpriseLogo(enterpriseLogoUrl);
                enterprise.setEnterpriseLicense(enterpriseLicenseUrl);
                if (checkEmailExist(updateEnterpriseBody.getEnterpriseEmail())){
                    return JsonResult.build(400,"邮箱已被使用");
                }
                enterprise.setEnterpriseEmail(updateEnterpriseBody.getEnterpriseEmail());
                enterprise.setEnterpriseUser(updateEnterpriseBody.getEnterpriseUser());
                enterprise.setEnterpriseAddress(updateEnterpriseBody.getEnterpriseAddress());
                //修改数据库信息
                enterpriseMapper.updateByPrimaryKeySelective(enterprise);
                //更新redis数据信息
                jedisClient.set(USER_SESSION + ":" + token,JsonUtils.objectToJson(enterprise));
                //修改token时长
                jedisClient.expire(USER_SESSION + ":" + token,SESSION_EXPIRE);
                //设置地址信息
                EnterpriseAddress enterpriseAddress = new EnterpriseAddress();
                enterpriseAddress.setEnterpriseId(enterprise.getEnterpriseId());
                enterpriseAddress.setEnterpriseAddress(enterprise.getEnterpriseAddress());
                enterpriseAddress.setEnterpriseProvince(updateEnterpriseBody.getEnterpriseProvince());
                enterpriseAddress.setEnterpriseCity(updateEnterpriseBody.getEnterpriseCity());
                EnterpriseAddressExample example = new EnterpriseAddressExample();
                example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
                enterpriseAddressMapper.updateByExample(enterpriseAddress,example);
                //返回json结果
                CompleteEnterpriseInfoResultBody completeEnterpriseInfoResultBody = new CompleteEnterpriseInfoResultBody();
                completeEnterpriseInfoResultBody.setToken(token);
                completeEnterpriseInfoResultBody.setEnterpriseId(enterprise.getEnterpriseId());
                completeEnterpriseInfoResultBody.setEnterpriseName(updateEnterpriseBody.getEnterpriseName());
                completeEnterpriseInfoResultBody.setEnterpriseEmail(updateEnterpriseBody.getEnterpriseEmail());
                completeEnterpriseInfoResultBody.setEnterpriseLegalrepresentative(enterprise.getEnterpriseLegalrepresentative());
                completeEnterpriseInfoResultBody.setEnterpriseAddress(updateEnterpriseBody.getEnterpriseAddress());
                completeEnterpriseInfoResultBody.setEnterpriseProvince(updateEnterpriseBody.getEnterpriseProvince());
                completeEnterpriseInfoResultBody.setEnterpriseCity(updateEnterpriseBody.getEnterpriseCity());
                completeEnterpriseInfoResultBody.setEnterpriseLicenseUrl(enterpriseLicenseUrl);
                completeEnterpriseInfoResultBody.setEnterpriseLogoUrl(enterpriseLogoUrl);
                return JsonResult.ok(completeEnterpriseInfoResultBody);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult updateEnterprisePhone(UpdateEnterprisePhoneBody updateEnterprisePhoneBody) {
        String token = updateEnterprisePhoneBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
           if (StringUtils.isNoneBlank(json)){
               Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
               String enterprisePhone = enterprise.getEnterprisePhone();
            try {
                if (Integer.parseInt(SUCCESS_CODE_VALUE) == MessageApi.setVerifySmsCode(enterprisePhone,updateEnterprisePhoneBody.getCheckCode())) {
                    if (checkPhoneExist(updateEnterprisePhoneBody.getPhone())){
                        return JsonResult.build(400,"手机号已被注册");
                    }
                    enterprise.setEnterprisePhone(updateEnterprisePhoneBody.getPhone());
                    //更新数据库
                    enterpriseMapper.updateByPrimaryKeySelective(enterprise);
                    //更新redis
                    jedisClient.set(USER_SESSION + ":" + token,JsonUtils.objectToJson(enterprise));
                    jedisClient.expire(USER_SESSION + ":" + token,SESSION_EXPIRE);
                    updateEnterprisePhoneBody.setCheckCode(null);
                    return JsonResult.ok(updateEnterprisePhoneBody);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
             return JsonResult.build(403,"短信验证码错误");
           }
        }
        return JsonResult.build(400,"用户未登录，无法修改");
    }

    @Override
    public JsonResult updateEnterprisePassword(UpdateEnterprisePasswordBody updateEnterprisePasswordBody) {
        String token = updateEnterprisePasswordBody.getToken();
        if (StringUtils.isNoneBlank(token)) {
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)) {
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                if (enterprise.getEnterprisePassword().equals(MD5.generateMD5(updateEnterprisePasswordBody.getOldPassword()))){
                    enterprise.setEnterprisePassword(MD5.generateMD5(updateEnterprisePasswordBody.getNewPassword()));
                    //更新数据库
                    enterpriseMapper.updateByPrimaryKeySelective(enterprise);
                    //更新redis
                    jedisClient.set(USER_SESSION + ":" + token,JsonUtils.objectToJson(enterprise));
                    jedisClient.expire(USER_SESSION + ":" + token,SESSION_EXPIRE);
                    return JsonResult.ok();
                }
            }
        }
        return JsonResult.build(400,"用户未登录，无法修改");
    }

    @Override
    public JsonResult forgetEnterprisePassword(ForgetPasswordBody forgetPasswordBody) {
        String token = forgetPasswordBody.getToken();
        if (StringUtils.isNoneBlank(token)) {
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)) {
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                try {
                    if (Integer.parseInt(SUCCESS_CODE_VALUE) == MessageApi.setVerifySmsCode(enterprise.getEnterprisePhone(),forgetPasswordBody.getCheckCode())) {
                        enterprise.setEnterprisePassword(MD5.generateMD5(forgetPasswordBody.getNewPassword()));
                        //更新数据库
                        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
                        //更新redis
                        jedisClient.set(USER_SESSION + ":" + token,JsonUtils.objectToJson(enterprise));
                        jedisClient.expire(USER_SESSION + ":" + token,SESSION_EXPIRE);
                        //设置json返回值
                        TokenResult result = new TokenResult();
                        result.setToken(token);
                        return JsonResult.ok(result);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                return JsonResult.build(403,"短信验证码错误");
            }
        }
        return JsonResult.build(400,"用户未登录，无法修改");
    }


    @Override
    public JsonResult findEnterpriseAddress(String token) {
        String json = jedisClient.get(USER_SESSION + ":" + token);
        if (StringUtils.isNoneBlank(json)){
            Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
            EnterpriseAddressExample example = new EnterpriseAddressExample();
            example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
            List<EnterpriseAddress> enterpriseAddresses = enterpriseAddressMapper.selectByExample(example);
            if (null != enterpriseAddresses && enterpriseAddresses.size() > 0){
                EnterpriseAddress address =  enterpriseAddresses.get(0);
                EnterpriseAddressResult result = new EnterpriseAddressResult();
                result.setToken(token);
                result.setEnterpriseAddress(address.getEnterpriseAddress());
                result.setEnterpriseProvince(address.getEnterpriseProvince());
                result.setEnterpriseCity(address.getEnterpriseCity());
                result.setEnterpriseId(address.getEnterpriseId());
                return JsonResult.ok(result);
            }
        }
        return JsonResult.build(400,"查询的公司不存在");
    }
}
