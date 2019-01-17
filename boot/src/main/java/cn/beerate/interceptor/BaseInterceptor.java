package cn.beerate.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseInterceptor implements HandlerInterceptor {

    private Log log = LogFactory.getLog(AdminLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("from:["+request.getRemoteHost()+"] , session : ["+request.getRequestedSessionId()+"]");

        return true;
    }
}
