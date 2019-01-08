package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_industry_analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryAnalysisDaoImpl extends JpaRepository<t_industry_analysis,Long> {
}
