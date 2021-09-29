package it.euris.exam.teslabattery_bd.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.exam.teslabattery_bd.data.dto.ProductionCycleDto;
import it.euris.exam.teslabattery_bd.data.model.ProductionCycle;
import it.euris.exam.teslabattery_bd.enums.ProductionCycleStatus;
import it.euris.exam.teslabattery_bd.exception.IdMustBeNullException;
import it.euris.exam.teslabattery_bd.exception.IdMustNotBeNullException;
import it.euris.exam.teslabattery_bd.repository.ProductionCycleRepository;
import it.euris.exam.teslabattery_bd.repository.projection.ProductionCycleMonthAmount;
import it.euris.exam.teslabattery_bd.service.ProductionCycleService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Service
public class ProductionCycleServiceImpl implements ProductionCycleService {
  
  @Autowired
  private ProductionCycleRepository productionCycleRepository;

  @Override
  public List<ProductionCycleDto> getAll() {
    return productionCycleRepository.findAll()
        .stream().map(ProductionCycle::toDto).collect(Collectors.toList());
  }

  @Override
  public ProductionCycleDto get(Long id) {
    return productionCycleRepository.findById(id)
        .map(ProductionCycle::toDto).orElse(null);
  }

  @Override
  public ProductionCycleDto add(ProductionCycleDto productionCycleDto) {
    if(productionCycleDto.getId() != null)
      throw new IdMustBeNullException();
      
    return productionCycleRepository.save(productionCycleDto.toModel()).toDto();
  }

  @Override
  public ProductionCycleDto update(ProductionCycleDto productionCycleDto) {
    if(productionCycleDto.getId() == null)
      throw new IdMustNotBeNullException();
      
    return productionCycleRepository.save(productionCycleDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    productionCycleRepository.deleteById(id);
    return productionCycleRepository.findById(id).isEmpty();
  }
  
  @Override
  public List<ProductionCycleMonthAmount> getCompletedByMonth() {
    return productionCycleRepository.getAmountByMonth(ProductionCycleStatus.COMPLETATO);
  }

  @Override
  public List<ProductionCycleMonthAmount> getFaildedByMonth() {
    return productionCycleRepository.getAmountByMonth(ProductionCycleStatus.FALLITO);
  }

  @Override
  public List<ProductionCycleMonthAmount> getAllByMonth(){
    return productionCycleRepository.getAllByMonth();
  }
}
