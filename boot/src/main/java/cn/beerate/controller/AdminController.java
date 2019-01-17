package cn.beerate.controller;

import cn.beerate.common.Constants.SessionKey;
import cn.beerate.common.Message;
import cn.beerate.model.entity.t_admin;
import cn.beerate.service.AdminService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private Log log = LogFactory.getLog(AdminController.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/login")
    @ResponseBody
    public Message login(@RequestParam("account") String account , @RequestParam("password") String password){
        Message<t_admin> message = adminService.login(account,password);

        //登录失败
        if(message.getCode()==Message.Code.ERROR){
            return message;
        }

        //保存登录信息
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(SessionKey.BACK_+session.getId(),message.getData());
        log.info(" has created by user login session : ["+session.getId()+"] ");

        return Message.success("登录成功");
    }

    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public Message loginOut(){
        //获取当前会话
        HttpSession session = httpServletRequest.getSession(false);

        if(session==null){
            return Message.ok("当前会话未登录");
        }

        session.removeAttribute(SessionKey.BACK_+session.getId());
        return Message.ok("登出成功");
    }
}
