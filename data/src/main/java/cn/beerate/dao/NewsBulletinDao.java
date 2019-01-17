package cn.beerate.dao;

import cn.beerate.model.entity.stock.t_news_bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsBulletinDao extends JpaRepository<t_news_bulletin,Long> {
}
