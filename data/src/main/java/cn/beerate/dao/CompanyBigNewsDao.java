package cn.beerate.dao;

import cn.beerate.model.entity.stock.t_company_big_news;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBigNewsDao extends JpaRepository<t_company_big_news,Long> {

    /**
     * 根据股票代码查询
     * @param stockCode
     * @return t_company_big_news
     */
    t_company_big_news findByStockCode(String stockCode);
}
