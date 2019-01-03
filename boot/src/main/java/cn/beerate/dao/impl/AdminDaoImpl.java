package cn.beerate.dao.impl;

import cn.beerate.model.entity.t_admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDaoImpl extends JpaRepository<t_admin,Long> {

    t_admin findByAccountAndAndPassword(String account, String password);
}
