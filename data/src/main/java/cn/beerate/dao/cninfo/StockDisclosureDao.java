package cn.beerate.dao.cninfo;


import cn.beerate.model.entity.t_stock_disclosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDisclosureDao extends JpaRepository<t_stock_disclosure,Long> {

}
