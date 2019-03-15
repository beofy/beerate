package cn.beerate.dao.eastmoney.f10.newfinanceanalysis;

import cn.beerate.dao.IBaseDao;
import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.t_eastmoney_dubang;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DubangDao extends IBaseDao<t_eastmoney_dubang> {

    List<t_eastmoney_dubang> findByCodeAndTypeOrderByCreateTimeDesc(String code,String type);

}
