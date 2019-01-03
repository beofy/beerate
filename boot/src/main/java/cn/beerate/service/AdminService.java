package cn.beerate.service;

import cn.beerate.model.entity.t_admin;
import org.springframework.stereotype.Service;

public interface AdminService  {

    t_admin loggin(String account,String password);

}
