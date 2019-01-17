package cn.beerate.dao;

import cn.beerate.model.entity.stock.t_operations_required;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsRequiredDao extends JpaRepository<t_operations_required,Long> {
}
