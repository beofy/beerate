package cn.beerate.interceptor;

import cn.beerate.common.Constants.SessionKey;
import cn.beerate.common.Message;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 后台登录拦截器
 */
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        //解决跨域
        if (CorsUtils.isCorsRequest(request)){
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,PATCH,DELETE,OPTIONS,TRACE");
            response.setHeader("Access-Control-Allow-Headers","*");
            response.setContentType("application/json;application/xml;text/plain;text/html");
        }

        //登录拦截
        if(session==null||session.getAttribute(SessionKey.BACK_+session.getId())==null){
            PrintWriter writer = response.getWriter();
            Message message = Message.error("未登录");
            message.setCode(Message.Code.NOT_LOGIN);
            writer.write(JSONObject.toJSONString(message));
            writer.close();

            return false;
        }

        return true;
    }

}
