package cn.beerate.dao.eastmoney.f10.newfinanceanalysis;

import cn.beerate.dao.IBaseDao;
import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.t_eastmoney_main_target;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MainTargetDao extends IBaseDao<t_eastmoney_main_target> {

    List<t_eastmoney_main_target> findByCodeAndTypeOrderByCreateTimeDesc(String code,String type);

}
