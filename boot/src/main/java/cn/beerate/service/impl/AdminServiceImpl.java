package cn.beerate.service.impl;

import cn.beerate.dao.Impl.AdminDaoImpl;
import cn.beerate.model.entity.t_admin;
import cn.beerate.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDaoImpl adminDao;

    @Override
    public t_admin loggin(String account, String password) {
       return   adminDao.findByAccountAndPassword(account, password);
    }
}
