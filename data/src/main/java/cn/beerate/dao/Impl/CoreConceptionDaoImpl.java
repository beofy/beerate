package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_core_conception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreConceptionDaoImpl extends JpaRepository<t_core_conception,Long> {

}
