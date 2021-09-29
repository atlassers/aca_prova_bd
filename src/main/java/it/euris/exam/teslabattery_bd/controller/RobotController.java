package it.euris.exam.teslabattery_bd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.exam.teslabattery_bd.data.dto.RobotDto;
import it.euris.exam.teslabattery_bd.service.RobotService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@RestController
@RequestMapping("/robots")
public class RobotController {

  @Autowired
  private RobotService robotService;
  
  @GetMapping("/v1")
  public List<RobotDto> getAll(){
    return robotService.getAll();
  }

  @GetMapping("/v1/{id}")
  public RobotDto get(@PathVariable("id") Long id) {
    return robotService.get(id);
  }

  @PostMapping("/v1")
  public RobotDto add(@RequestBody RobotDto robotDto) {
    return robotService.add(robotDto);
  }

  @PutMapping("/v1")
  public RobotDto update(@RequestBody RobotDto robotDto) {
    return robotService.update(robotDto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return robotService.delete(id);
  }
}
