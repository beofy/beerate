package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_company_big_news;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBigNewsDaoImpl extends JpaRepository<t_company_big_news,Long> {
}
