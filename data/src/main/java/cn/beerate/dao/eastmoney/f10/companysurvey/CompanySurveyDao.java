package cn.beerate.dao.eastmoney.f10.companysurvey;

import cn.beerate.model.entity.eastmoney.f10.companysurvey.t_eastmoney_companysurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySurveyDao extends JpaRepository<t_eastmoney_companysurvey,Long> {

    /**
     * 根据股票代码查询
     * @param code 股票代码
     * @return t_eastmoney_companysurvey
     */
    t_eastmoney_companysurvey findByCode(String code);

}
