package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.ManagerLoginBody;
import cn.ersharing.common.ResponsePojo.TokenResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.common.util.MD5;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.ManagerMapper;
import cn.ersharing.pojo.Manager;
import cn.ersharing.pojo.ManagerExample;
import cn.ersharing.service.ManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${MANAGER_SESSION}")
    private String MANAGER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonResult loginManager(ManagerLoginBody managerLoginBody) {
        if (StringUtils.isNoneBlank(managerLoginBody.getManagerName()) && StringUtils.isNoneBlank(managerLoginBody.getManagerPassword())){
            ManagerExample example = new ManagerExample();
            example.createCriteria().andManagerNameEqualTo(managerLoginBody.getManagerName());
            List<Manager> managers = managerMapper.selectByExample(example);
            if (managers != null && managers.size() > 0){
                Manager manager = managers.get(0);
                if (manager.getManagerPassword().equals(MD5.generateMD5(managerLoginBody.getManagerPassword()))){
                    TokenResult result = new TokenResult();
                    //生成token。用户唯一标识
                    String token = MD5.generateMD5(manager.getManagerId() + "" + System.currentTimeMillis());
                    result.setToken(token);
                    //设置redis缓存用户token信息
                    jedisClient.set(MANAGER_SESSION + ":" + token, JsonUtils.objectToJson(manager));
                    jedisClient.expire(MANAGER_SESSION + ":" + token,SESSION_EXPIRE);
                    return JsonResult.ok(result);
                }
                return JsonResult.build(403,"用户名或密码不正确");
            }
        }
        return JsonResult.build(400,"用户名或密码不能为空");
    }

}
