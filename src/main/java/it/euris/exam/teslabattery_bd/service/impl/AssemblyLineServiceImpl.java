package it.euris.exam.teslabattery_bd.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.exam.teslabattery_bd.data.dto.AssemblyLineDto;
import it.euris.exam.teslabattery_bd.data.model.AssemblyLine;
import it.euris.exam.teslabattery_bd.exception.IdMustBeNullException;
import it.euris.exam.teslabattery_bd.exception.IdMustNotBeNullException;
import it.euris.exam.teslabattery_bd.repository.AssemblyLineRepository;
import it.euris.exam.teslabattery_bd.service.AssemblyLineService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Service
public class AssemblyLineServiceImpl implements AssemblyLineService {
  
  @Autowired
  private AssemblyLineRepository assemblyLineRepository;

  @Override
  public List<AssemblyLineDto> getAll() {
    return assemblyLineRepository.findAll()
        .stream().map(AssemblyLine::toDto).collect(Collectors.toList());
  }

  @Override
  public AssemblyLineDto get(Long id) {
    return assemblyLineRepository.findById(id)
        .map(AssemblyLine::toDto).orElse(null);
  }

  @Override
  public AssemblyLineDto add(AssemblyLineDto assemblyLineDto) {
    if(assemblyLineDto.getId() != null)
      throw new IdMustBeNullException();
      
    return assemblyLineRepository.save(assemblyLineDto.toModel()).toDto();
  }

  @Override
  public AssemblyLineDto update(AssemblyLineDto assemblyLineDto) {
    if(assemblyLineDto.getId() == null)
      throw new IdMustNotBeNullException();
      
    return assemblyLineRepository.save(assemblyLineDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    assemblyLineRepository.deleteById(id);
    return assemblyLineRepository.findById(id).isEmpty();
  }
}
