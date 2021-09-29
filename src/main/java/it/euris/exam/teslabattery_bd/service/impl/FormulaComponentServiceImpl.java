package it.euris.exam.teslabattery_bd.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.exam.teslabattery_bd.data.dto.FormulaComponentDto;
import it.euris.exam.teslabattery_bd.data.model.FormulaComponent;
import it.euris.exam.teslabattery_bd.data.model.key.FormulaComponentKey;
import it.euris.exam.teslabattery_bd.repository.FormulaComponentRepository;
import it.euris.exam.teslabattery_bd.service.FormulaComponentService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Service
public class FormulaComponentServiceImpl implements FormulaComponentService {
  
  @Autowired
  private FormulaComponentRepository formulaComponentRepository;

  @Override
  public List<FormulaComponentDto> getAll() {
    return formulaComponentRepository.findAll()
        .stream().map(FormulaComponent::toDto).collect(Collectors.toList());
  }

  @Override
  public FormulaComponentDto get(Long formulaId, Long componentId) {
    FormulaComponentKey id = new FormulaComponentKey(formulaId, componentId);
    return formulaComponentRepository.findById(id)
        .map(FormulaComponent::toDto).orElse(null);
  }

  @Override
  public FormulaComponentDto add(FormulaComponentDto formulaComponentDto) {
    return formulaComponentRepository.save(formulaComponentDto.toModel()).toDto();
  }

  @Override
  public FormulaComponentDto update(FormulaComponentDto formulaComponentDto) {
    return formulaComponentRepository.save(formulaComponentDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long formulaId, Long componentId) {
    FormulaComponentKey id = new FormulaComponentKey(formulaId, componentId);
    formulaComponentRepository.deleteById(id);
    return formulaComponentRepository.findById(id).isEmpty();
  }
}
