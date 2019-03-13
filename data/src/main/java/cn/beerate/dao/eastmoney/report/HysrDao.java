package cn.beerate.dao.eastmoney.report;

import cn.beerate.dao.IBaseDao;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_ggsr;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_hysr;
import org.springframework.stereotype.Repository;

@Repository
public interface HysrDao extends IBaseDao<t_eastmoney_hysr> {

    t_eastmoney_hysr findByInfoCode(String infoCode);

}
