package it.euris.exam.teslabattery_bd.service;

import java.util.List;
import it.euris.exam.teslabattery_bd.data.dto.ProductionCycleDto;
import it.euris.exam.teslabattery_bd.repository.projection.ProductionCycleMonthAmount;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface ProductionCycleService {

  public List<ProductionCycleDto> getAll();
  public ProductionCycleDto get(Long id);
  public ProductionCycleDto add(ProductionCycleDto productionCycleDto);
  public ProductionCycleDto update(ProductionCycleDto productionCycleDto);
  public Boolean delete(Long id);
  
  public List<ProductionCycleMonthAmount> getCompletedByMonth();
  public List<ProductionCycleMonthAmount> getFaildedByMonth();
  public List<ProductionCycleMonthAmount> getAllByMonth();
  
  public Double getSuccessRate();
}
