package it.euris.exam.teslabattery_bd.service;

import java.util.List;
import it.euris.exam.teslabattery_bd.data.dto.RobotDto;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface RobotService {

  public List<RobotDto> getAll();
  public RobotDto get(Long id);
  public RobotDto add(RobotDto robotDto);
  public RobotDto update(RobotDto robotDto);
  public Boolean delete(Long id);
}
