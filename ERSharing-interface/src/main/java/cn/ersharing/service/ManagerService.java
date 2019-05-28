package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.ManagerLoginBody;
import cn.ersharing.common.pojo.JsonResult;

/**
 * 管理员service
 * @author haojie
 * @date 2019/1/16
 */
public interface ManagerService {
    /**
     * 管理员登录
     * @param managerLoginBody 管理员登录信息
     * @return
     */
    JsonResult loginManager(ManagerLoginBody managerLoginBody);


}
