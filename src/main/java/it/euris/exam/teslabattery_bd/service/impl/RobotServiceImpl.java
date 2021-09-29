package it.euris.exam.teslabattery_bd.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.exam.teslabattery_bd.data.dto.RobotDto;
import it.euris.exam.teslabattery_bd.data.model.Robot;
import it.euris.exam.teslabattery_bd.exception.IdMustBeNullException;
import it.euris.exam.teslabattery_bd.exception.IdMustNotBeNullException;
import it.euris.exam.teslabattery_bd.repository.RobotRepository;
import it.euris.exam.teslabattery_bd.service.RobotService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Service
public class RobotServiceImpl implements RobotService {
  
  @Autowired
  private RobotRepository robotRepository;

  @Override
  public List<RobotDto> getAll() {
    return robotRepository.findAll()
        .stream().map(Robot::toDto).collect(Collectors.toList());
  }

  @Override
  public RobotDto get(Long id) {
    return robotRepository.findById(id)
        .map(Robot::toDto).orElse(null);
  }

  @Override
  public RobotDto add(RobotDto robotDto) {
    if(robotDto.getId() != null)
      throw new IdMustBeNullException();
      
    return robotRepository.save(robotDto.toModel()).toDto();
  }

  @Override
  public RobotDto update(RobotDto robotDto) {
    if(robotDto.getId() == null)
      throw new IdMustNotBeNullException();
      
    return robotRepository.save(robotDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    robotRepository.deleteById(id);
    return robotRepository.findById(id).isEmpty();
  }
}
