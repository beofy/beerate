package cn.beerate.dao.eastmoney.f10.companysurvey;

import cn.beerate.model.entity.eastmoney.f10.companysurvey.t_eastmoney_jbzl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JbzlDao extends JpaRepository<t_eastmoney_jbzl,Long> {
}
