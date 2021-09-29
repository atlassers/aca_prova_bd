package it.euris.exam.teslabattery_bd.service;

import java.util.List;
import it.euris.exam.teslabattery_bd.data.dto.ComponentDto;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface ComponentService {

  public List<ComponentDto> getAll();
  public ComponentDto get(Long id);
  public ComponentDto add(ComponentDto componentDto);
  public ComponentDto update(ComponentDto componentDto);
  public Boolean delete(Long id);
}
