package cn.beerate.dao.Impl;

import cn.beerate.model.entity.stock.operationsrequired.t_operations_required;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsRequiredDaoImpl extends JpaRepository<t_operations_required,Long> {
}
