package cn.beerate.interceptor;

import cn.beerate.common.Constants.SessionKey;
import cn.beerate.common.Message;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 后台登录拦截器
 */
public class AdminLoginInterceptor implements HandlerInterceptor {

    private Log log = LogFactory.getLog(AdminLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String seesionId = session.getId();

        //登录拦截
        if(session.getAttribute(SessionKey.BACK_+seesionId)==null){
            log.debug("login interceptor current sessionId :"+seesionId);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;application/xml;text/plain;text/html");//;
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
