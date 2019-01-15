package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.model.entity.t_admin;
import org.springframework.stereotype.Service;

public interface AdminService  {

    Message<t_admin> login(String account, String password);


}
