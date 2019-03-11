package cn.beerate.dao.eastmoney.f10.companybignews;

import cn.beerate.model.entity.eastmoney.f10.companybignews.t_eastmoney_lhbd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LhbdDao extends JpaRepository<t_eastmoney_lhbd,Long> {

    void deleteByCode(String code);

    List<t_eastmoney_lhbd> findByCode(String code);

}
