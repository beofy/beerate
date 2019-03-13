package cn.beerate.dao.eastmoney.report;

import cn.beerate.dao.IBaseDao;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_ggsr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GgsrDao extends IBaseDao<t_eastmoney_ggsr> {

    t_eastmoney_ggsr findByInfoCode(String infoCode);


}
