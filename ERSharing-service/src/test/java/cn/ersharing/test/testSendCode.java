package cn.ersharing.test;

import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.service.impl.EnterpriseServiceImpl;
import org.junit.Test;

import java.util.Map;

public class testSendCode {

    @Test
    public void testSendCode() throws Exception{
        EnterpriseServiceImpl service = new EnterpriseServiceImpl();
        JsonResult code = service.sendCode("18682328917");
        System.out.println(code.getStatus() + " : " + code.getMsg());
    }
}
