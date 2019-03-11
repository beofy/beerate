package cn.beerate.dao;

import cn.beerate.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

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
     void deleteByCode(String code);
}
