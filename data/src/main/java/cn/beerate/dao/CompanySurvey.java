package cn.beerate.dao;

import cn.beerate.model.entity.stock.t_company_survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySurvey extends JpaRepository<t_company_survey,Long> {

}
