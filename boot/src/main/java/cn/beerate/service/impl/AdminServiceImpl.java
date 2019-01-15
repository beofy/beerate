package cn.beerate.service.impl;

import cn.beerate.common.Constants.SecurityKey;
import cn.beerate.common.Message;
import cn.beerate.dao.Impl.AdminDaoImpl;
import cn.beerate.model.entity.t_admin;
import cn.beerate.security.Encrypt;
import cn.beerate.service.AdminService;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDaoImpl adminDao;

    @Override
    public Message<t_admin> login(String account, String password) {
        if(StringUtil.isBlank(account)){
             return Message.error("账号不能为空");
        }

        if(StringUtil.isBlank(password)){
            return Message.error("密码不能为空");
        }

        String encPassword= Encrypt.MD5(password+SecurityKey.md5Key);
        t_admin admin = adminDao.findByAccountAndPassword(account, encPassword);
        if(admin==null){
            return Message.error("账户不存在或者密码错误");
        }

        return Message.success(admin);
    }
}
