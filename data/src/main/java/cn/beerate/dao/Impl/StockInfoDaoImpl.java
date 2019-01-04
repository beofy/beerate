package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StockInfoDaoImpl extends JpaRepository<t_stock_info,Long> {




    /**
     * 查询所有股票代码
     *
     * @return
     */
    @Query(value = "select code from t_stock_info", nativeQuery = true)
    String[] findAllStockCode();

    /**
     * 根据股票代码查询信息
     */
    t_stock_info findByCode(String code);


}
