package cn.beerate.dao.Impl;

import cn.beerate.model.entity.t_admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDaoImpl extends JpaRepository<t_admin,Long> {

    t_admin findByAccountAndPassword(String account, String password);
}
