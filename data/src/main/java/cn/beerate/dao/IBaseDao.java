package cn.beerate.dao;

import cn.beerate.model.Model;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_ggsr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
public interface IBaseDao<T extends Model> extends JpaRepository<T,Long> {

    /**
     * 根据股票代码查询
     */
    List<T> findByCode(String code);

    /**
     * 根据股票代码查询最新一条
     */
    T findByCodeOrderByCreateTimeAsc(String code);

    /**
     * 根据股票代码删除
     */
    @Transactional
     int deleteByCode(String code);

    /**
     * 根据股票分页查询
     */
    Page<T> findByCode(String code, Pageable pageable);
}
