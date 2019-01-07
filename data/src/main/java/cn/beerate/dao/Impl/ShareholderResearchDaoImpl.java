package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_shareholder_research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareholderResearchDaoImpl extends JpaRepository<t_shareholder_research,Long> {

}
