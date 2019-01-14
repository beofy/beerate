package cn.beerate.controller;


import cn.beerate.common.Message;
import cn.beerate.model.entity.t_admin;
import cn.beerate.service.AdminService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    @ResponseBody
    public Message login(){
        return Message.ok("响应成功");
    }
}
