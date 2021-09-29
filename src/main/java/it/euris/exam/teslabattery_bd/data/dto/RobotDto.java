package it.euris.exam.teslabattery_bd.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.Robot;
import it.euris.exam.teslabattery_bd.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RobotDto implements Dto {

  private String id;
  private String task;
  private String position;
  private String model;
  
  private List<AssemblyLineDto> assemblyLines;

  @Override
  public Robot toModel() {
    Robot robot = Robot.builder()
        .id(UT.toLong(id))
        .task(UT.toRobotTask(task))
        .position(UT.toLong(position))
        .model(model)
        .build();
    
    if (assemblyLines != null)
      robot.setAssemblyLines(assemblyLines.stream().map(AssemblyLineDto::toModel).collect(Collectors.toSet()));
    
    return robot;
  }
}
