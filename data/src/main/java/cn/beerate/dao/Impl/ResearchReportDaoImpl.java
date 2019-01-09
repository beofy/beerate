package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_research_report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchReportDaoImpl extends JpaRepository<t_research_report,Long> {
}
