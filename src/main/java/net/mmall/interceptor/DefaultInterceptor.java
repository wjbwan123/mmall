package net.mmall.interceptor;

import com.alibaba.fastjson.JSONException;
import com.google.gson.Gson;
import net.mmall.entity.Region;
import net.mmall.utils.Constants;
import net.mmall.utils.CookieUtils;
import net.mmall.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认拦截器
 *
 * @author hanyi
 * @date 2017年04月10日
 */
public class DefaultInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        //todo
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //todo
    }
}
