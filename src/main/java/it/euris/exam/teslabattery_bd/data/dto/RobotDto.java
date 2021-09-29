package it.euris.exam.teslabattery_bd.data.dto;

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

  @Override
  public Robot toModel() {
    return Robot.builder()
        .id(UT.toLong(id))
        .task(UT.toRobotTask(task))
        .position(UT.toLong(position))
        .model(model)
        .build();
  }
}
