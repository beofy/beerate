package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_business_analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAnalysisDaoImpl extends JpaRepository<t_business_analysis,Long> {

}
