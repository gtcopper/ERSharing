package cn.ersharing.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MsgApi {
    /**
     * 发送验证码的请求路径URL
     */
    private static final String
            SERVER_URL = "https://api.netease.im/sms/sendcode.action";
    /**
     * 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
     */
    private static final String
            APP_KEY = "661b68029b468cd911b3985612e7e5b3";
    /**
     * 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
     */
    private static final String APP_SECRET = "12b3a5295a30";
    /**
     * 随机数
     */
    private static final String NONCE = "123456";
    //短信模板ID
//    private static final String TEMPLATEID = "3057527";

    /**
     * 验证码长度，范围4～10，默认为4
     */
    private static final String CODELEN = "6";

    /**
     * 发送验证码
     * @param phone
     * @return
     * @throws IOException
     */
    public static Map<String, Object> sendCode(String phone) throws IOException {
        Map<String,String> header = new HashMap<>();
        Map<String,String> body = new HashMap<>();
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
         /*
         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
         */
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        header.put("AppKey", APP_KEY);
        header.put("Nonce", NONCE);
        header.put("CurTime", curTime);
        header.put("CheckSum", checkSum);
        header.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");



//        body.put("templateid", TEMPLATEID);
        body.put("mobile", phone);
        body.put("codeLen", CODELEN);

        String response = HttpClientHelper.sendPost(SERVER_URL , header , body);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map;

        // convert JSON string to Map
        map = mapper.readValue(response, new TypeReference<Map<String, String>>(){});

        return map;
    }

//    public static void main(String[] args){
//        try {
//           Map<String,Object> map = sendCode("18682328917");
//            for (Map.Entry<String,Object> entry :
//                    map.entrySet()) {
//                System.out.print(entry.getKey() + " : " + entry.getValue());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
