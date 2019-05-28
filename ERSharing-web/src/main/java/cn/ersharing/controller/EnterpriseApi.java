package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.*;
import cn.ersharing.common.ResponsePojo.EnterpriseInfoResult;
import cn.ersharing.common.ResponsePojo.EnterpriseInformationResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.EnterpriseAddress;
import cn.ersharing.service.EnterpriseService;
import cn.ersharing.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * 公司基本模块
 */
@RestController
@RequestMapping(value = "/api/enterprise")
public class EnterpriseApi {

    @Autowired(required = false)
    private EnterpriseService enterpriseService;


    @Value("${FILE_LOCATION_URL}")
    private String FILE_LOCATION_URL;

    @Value("${FILE_LICENSE_LOCATION}")
    private String FILE_LICENSE_LOCATION;

    @Value("${FILE_LOGO_LOCATION}")
    private String FILE_LOGO_LOCATION;

    @Autowired
    private HttpSession session;

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/register/msg/{phone}", method = GET)
    public JsonResult phoneMessage(@PathVariable String phone){
        boolean exist = enterpriseService.checkPhoneExist(phone);
        if (exist){
            return  JsonResult.build(400,"手机号已存在");
        }
        return enterpriseService.sendCode(phone);
    }

    /**
     * 修改手机号或忘记密码发送的短信验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/update/msg/{phone}", method = GET)
    public JsonResult sendPhoneMessage(@PathVariable String phone){
        return enterpriseService.sendCode(phone);
    }

    /**
     * 注册
     *
     * @param registerBody { enterprise_user,phone,password,checkCode}
     * @return default JsonResult
     */
    @RequestMapping(value = "/register", method = POST)
    public JsonResult register(RegisterBody registerBody) {
        try {
//            registerBody.setEnterprise_user(new String(registerBody.getEnterprise_user().getBytes("ISO8859-1"),"UTF-8"));
            JsonResult result = enterpriseService.registerAccount(registerBody);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(500,"服务器异常");
    }

    /**
     * 登录
     * @param loginBody { phone,password}
     * @return loginResult{token}
     */
    @RequestMapping(value = "/login", method = POST)
    public JsonResult login(LoginBody loginBody) {
        JsonResult result = enterpriseService.login(loginBody);
        return result;
    }

    /**
     * 登出
     *
     * @param token 用户令牌
     * @return default JsonResult
     */
    @RequestMapping(value = "/logout", method = POST)
    public JsonResult logout(@RequestParam("token") String token) {
        JsonResult result = enterpriseService.logout(token);
        return result;
    }

    /**
     * 完善企业信息
     * @param completeEnterpriseInfoBody 完善信息主体信息
     * @param enterpriseLicense 企业营业执照图片
     * @param enterpriseLogo 企业logo图标
     * @return
     */
    @RequestMapping(value = "/infoComplete",method = POST)
    public JsonResult completeEnterpriseInfo(CompleteEnterpriseInfoBody completeEnterpriseInfoBody,
                                             @RequestParam(value = "enterpriseLicense") MultipartFile enterpriseLicense,
                                             @RequestParam(value = "enterpriseLogo") MultipartFile enterpriseLogo){
        JsonResult result;
        try {
            String enterpriseLicenseUrl = executeUploadFile(enterpriseLicense, FILE_LICENSE_LOCATION);
            String enterpriseLogoUrl = executeUploadFile(enterpriseLogo, FILE_LOGO_LOCATION);
            result = enterpriseService.completeEnterpriseInfo(completeEnterpriseInfoBody,enterpriseLicenseUrl,enterpriseLogoUrl);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result = JsonResult.build(500,"服务器端异常");
        return result;
    }

    /**
     * 返回上传文件的URL
     * @param uploadFile
     * @return
     */
    private String executeUploadFile(MultipartFile uploadFile,String location) throws Exception{
        //获取源文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //获取文件的后缀名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //获取文件在硬盘中的真实路径
        String path;
        path = session.getServletContext().getRealPath(location);
        //设置文件在硬盘中的文件名
        File file = new File(path,System.nanoTime()+"_"+originalFilename);
        //完成文件写入服务器端
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        uploadFile.transferTo(file);
        return location + file.getName();
    }

    /**
     * 公司信息
     *
     * @param token 用户令牌
     * @return
     */
    @RequestMapping(value = "/enterpriseInfo", method = POST)
    public JsonResult enterpriseInfo(@RequestParam("token") String token) {
        JsonResult result = enterpriseService.enterpriseInfo(token);
        return result;
    }

    /**
     * 公司信息
     *
     * @param  enterpriseId 企业id
     * @return
     */
    @RequestMapping(value = "/enterpriseInfoFromId", method = POST)
    public JsonResult enterpriseInfo(Integer enterpriseId,String token) {
        JsonResult enterpriseInfo = enterpriseService.findEnterpriseById(token,enterpriseId);
        return enterpriseInfo;
    }

    /**
     * 更新公司信息
     * @param updateEnterpriseBody 更新的企业信息主体
     * @param enterpriseLicense 企业营业执照图片
     * @param enterpriseLogo 企业logo图标
     * @return
     */
    @RequestMapping(value = "/updateEnterpriseInfo", method = POST)
    public JsonResult updateEnterpriseInfo(UpdateEnterpriseBody updateEnterpriseBody,
                                           @RequestParam(value = "enterpriseLicense") MultipartFile enterpriseLicense,
                                           @RequestParam(value = "enterpriseLogo") MultipartFile enterpriseLogo) {
        JsonResult result;
        try {
            String enterpriseLicenseUrl = executeUploadFile(enterpriseLicense, FILE_LICENSE_LOCATION);
            String enterpriseLogoUrl = executeUploadFile(enterpriseLogo, FILE_LOGO_LOCATION);
            result = enterpriseService.updateEnterpriseInfo(updateEnterpriseBody, enterpriseLicenseUrl, enterpriseLogoUrl);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result = JsonResult.build(500,"服务器端异常");
        return result;
    }

    /**
     * 修改企业手机号
     * @param updateEnterprisePhoneBody
     * @return
     */
    @RequestMapping(value = "/phoneModify",method = POST)
    public JsonResult updateEnterprisePhone(UpdateEnterprisePhoneBody updateEnterprisePhoneBody){
        JsonResult result = enterpriseService.updateEnterprisePhone(updateEnterprisePhoneBody);
        return result;
    }

    /**
     * 企业用户修改密码
     * @param updateEnterprisePasswordBody
     * @return
     */
    @RequestMapping(value = "/pwModify",method = POST)
    public JsonResult updateEnterprisePassword(UpdateEnterprisePasswordBody updateEnterprisePasswordBody){
        JsonResult result = enterpriseService.updateEnterprisePassword(updateEnterprisePasswordBody);
        return result;
    }

    /**
     * 企业用户忘记密码
     * @param forgetPasswordBody
     * @return
     */
    @RequestMapping(value = "/forgetPw",method = POST)
    public JsonResult forgetEnterprisePassword(ForgetPasswordBody forgetPasswordBody){
        JsonResult result = enterpriseService.forgetEnterprisePassword(forgetPasswordBody);
        return result;
    }

    /**
     * 查看公司地址列表
     *
     * @param token 用户令牌
     * @return EnterpriseAddressJson {}
     */
    @RequestMapping(value = "/addressList", method = POST)
    public JsonResult enterpriseAddressList(@RequestParam("token") String token) {
        JsonResult result = enterpriseService.findEnterpriseAddress(token);
        return result;
    }

}

