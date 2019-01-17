package cn.beerate.dao;

import cn.beerate.model.entity.stock.t_research_report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchReportDao extends JpaRepository<t_research_report,Long> {
}
