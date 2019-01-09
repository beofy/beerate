package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_profit_forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitForecastDaoImpl extends JpaRepository<t_profit_forecast,Long> {
}
