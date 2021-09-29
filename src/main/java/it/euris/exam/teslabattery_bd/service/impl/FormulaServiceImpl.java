package it.euris.exam.teslabattery_bd.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.exam.teslabattery_bd.data.dto.FormulaDto;
import it.euris.exam.teslabattery_bd.data.model.Formula;
import it.euris.exam.teslabattery_bd.exception.IdMustBeNullException;
import it.euris.exam.teslabattery_bd.exception.IdMustNotBeNullException;
import it.euris.exam.teslabattery_bd.repository.FormulaRepository;
import it.euris.exam.teslabattery_bd.service.FormulaService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Service
public class FormulaServiceImpl implements FormulaService {
  
  @Autowired
  private FormulaRepository formulaRepository;

  @Override
  public List<FormulaDto> getAll() {
    return formulaRepository.findAll()
        .stream().map(Formula::toDto).collect(Collectors.toList());
  }

  @Override
  public FormulaDto get(Long id) {
    return formulaRepository.findById(id)
        .map(Formula::toDto).orElse(null);
  }

  @Override
  public FormulaDto add(FormulaDto formulaDto) {
    if(formulaDto.getId() != null)
      throw new IdMustBeNullException();
      
    return formulaRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public FormulaDto update(FormulaDto formulaDto) {
    if(formulaDto.getId() == null)
      throw new IdMustNotBeNullException();
      
    return formulaRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    formulaRepository.deleteById(id);
    return formulaRepository.findById(id).isEmpty();
  }
}
