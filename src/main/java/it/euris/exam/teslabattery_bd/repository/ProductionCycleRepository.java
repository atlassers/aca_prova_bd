package it.euris.exam.teslabattery_bd.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.euris.exam.teslabattery_bd.data.model.ProductionCycle;
import it.euris.exam.teslabattery_bd.enums.ProductionCycleStatus;
import it.euris.exam.teslabattery_bd.repository.projection.ProductionCycleMonthAmount;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface ProductionCycleRepository extends JpaRepository<ProductionCycle, Long> {

  @Query(value = ""
      + "SELECT MONTHNAME(pc.endDate) as month, COUNT(pc.id) as amount "
      + "FROM ProductionCycle pc "
      + "WHERE status=:status "
      + "GROUP BY MONTH(pc.endDate) "
      + "ORDER BY MONTH(pc.endDate)")
  public List<ProductionCycleMonthAmount> getAmountByMonth(@Param("status") ProductionCycleStatus status);

  @Query(value = ""
      + "SELECT MONTHNAME(pc.endDate) as month, COUNT(pc.id) as amount "
      + "FROM ProductionCycle pc "
      + "GROUP BY MONTH(pc.endDate) "
      + "ORDER BY MONTH(pc.endDate)")
  public List<ProductionCycleMonthAmount> getAllByMonth();
}
