package cn.ersharing.interceptor;

import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 * @author haojie
 * @date 2019/1/11
 */
public class LoginInterceptor implements HandlerInterceptor {

    private String[] allowUrls;


    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Autowired
    private JedisClient jedisClient;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");

        if (allowUrls != null && allowUrls.length >= 1){
            for (String s: allowUrls
            ) {
                if (requestUrl.contains(s)){
                    return true;
                }
            }
        }

        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            response.getWriter().write(JsonUtils.objectToJson(JsonResult.build(400,"用户未登录")));
            return false;
        }
        String user_session = "USER_SESSION" + ":" + token;
        String manager_session = "MANAGER_SESSION" + ":" + token;
        String json = jedisClient.get(user_session);
        if (StringUtils.isNoneBlank(json) || StringUtils.isNoneBlank(manager_session)){
            return true;
        }
        response.getWriter().write(JsonUtils.objectToJson(JsonResult.build(400,"登录时间已过")));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
