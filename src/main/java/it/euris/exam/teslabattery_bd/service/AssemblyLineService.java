package it.euris.exam.teslabattery_bd.service;

import java.util.List;
import it.euris.exam.teslabattery_bd.data.dto.AssemblyLineDto;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface AssemblyLineService {

  public List<AssemblyLineDto> getAll();
  public AssemblyLineDto get(Long id);
  public AssemblyLineDto add(AssemblyLineDto assemblyLineDto);
  public AssemblyLineDto update(AssemblyLineDto assemblyLineDto);
  public Boolean delete(Long id);
}
