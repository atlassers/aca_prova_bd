package it.euris.exam.teslabattery_bd.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.AssemblyLine;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssemblyLineDto implements Dto {

  private String id;
  private String name;
  private String timeToComplete;

  @JsonIgnore
  List<RobotDto> robots;
  
  @Override
  public AssemblyLine toModel() {
    AssemblyLine assemblyLine = AssemblyLine.builder()
        .id(UT.toLong(id))
        .name(name)
        .timeToComplete(UT.toLong(timeToComplete))
        .build();
    
    if (robots != null)
      assemblyLine.setRobots(robots.stream().map(RobotDto::toModel).collect(Collectors.toSet()));
    
    return assemblyLine;
  }
}
