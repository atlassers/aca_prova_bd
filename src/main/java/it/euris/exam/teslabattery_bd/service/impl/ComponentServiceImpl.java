package it.euris.exam.teslabattery_bd.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.exam.teslabattery_bd.data.dto.ComponentDto;
import it.euris.exam.teslabattery_bd.data.model.Component;
import it.euris.exam.teslabattery_bd.exception.IdMustBeNullException;
import it.euris.exam.teslabattery_bd.exception.IdMustNotBeNullException;
import it.euris.exam.teslabattery_bd.repository.ComponentRepository;
import it.euris.exam.teslabattery_bd.service.ComponentService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Service
public class ComponentServiceImpl implements ComponentService {
  
  @Autowired
  private ComponentRepository componentRepository;

  @Override
  public List<ComponentDto> getAll() {
    return componentRepository.findAll()
        .stream().map(Component::toDto).collect(Collectors.toList());
  }

  @Override
  public ComponentDto get(Long id) {
    return componentRepository.findById(id)
        .map(Component::toDto).orElse(null);
  }

  @Override
  public ComponentDto add(ComponentDto componentDto) {
    if(componentDto.getId() != null)
      throw new IdMustBeNullException();
      
    return componentRepository.save(componentDto.toModel()).toDto();
  }

  @Override
  public ComponentDto update(ComponentDto componentDto) {
    if(componentDto.getId() == null)
      throw new IdMustNotBeNullException();
      
    return componentRepository.save(componentDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    componentRepository.deleteById(id);
    return componentRepository.findById(id).isEmpty();
  }
}
