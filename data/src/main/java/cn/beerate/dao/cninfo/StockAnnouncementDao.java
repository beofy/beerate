package cn.beerate.dao.cninfo;

import cn.beerate.model.entity.cninfo.t_stock_announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockAnnouncementDao extends JpaRepository<t_stock_announcement,Long> {

    /**
     * 获取所有的announcementId
     * @return String[]
     */
    @Query(value = "select announcementId from t_stock_announcement where secCode = ?",nativeQuery = true)
    String[] getAllannouncementId(String stockCode);

}
