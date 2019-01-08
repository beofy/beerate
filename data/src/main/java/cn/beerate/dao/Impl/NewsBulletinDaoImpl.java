package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.t_news_bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsBulletinDaoImpl extends JpaRepository<t_news_bulletin,Long> {
}
