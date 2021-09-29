package it.euris.exam.teslabattery_bd.data.dto;

import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.AssemblyLine;
import it.euris.exam.teslabattery_bd.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssemblyLineDto implements Dto {

  private String id;
  private String timeToComplete;

  @Override
  public AssemblyLine toModel() {
    return AssemblyLine.builder()
        .id(UT.toLong(id))
        .timeToComplete(UT.toLong(timeToComplete))
        .build();
  }
}
