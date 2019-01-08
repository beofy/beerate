package cn.beerate.controller;


import cn.beerate.common.Message;
import cn.beerate.model.entity.t_admin;
import cn.beerate.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/")
    @ResponseBody
    public Message login(HttpServletResponse response){
        Message<t_admin> message =Message.success(adminService.loggin("123","123"));
        message.setMsg("响应成功");
        return message;
    }
}
