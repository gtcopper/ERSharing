package cn.ersharing.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class ResultJson {
    /**
     * json返回数据模板
     *
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static Map<String, Object> createResultJsonBodyToMap(int status, String msg, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("msg", msg);
        result.put("data", data);

        return result;
    }

    public static Map<String, Object> createResultJsonBodyToMap(int status, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("msg", msg);

        return result;
    }

    public static String createResultJsonBodyToString(int status, String msg, Object data) throws JsonProcessingException {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("msg", msg);
        result.put("data", data);

        return new ObjectMapper().writeValueAsString(result);
    }

    public static String createResultJsonBodyToString(int status, String msg) throws JsonProcessingException {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("msg", msg);

        return new ObjectMapper().writeValueAsString(result);
    }
}
