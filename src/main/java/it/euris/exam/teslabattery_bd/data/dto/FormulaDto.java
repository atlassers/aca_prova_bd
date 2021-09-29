package it.euris.exam.teslabattery_bd.data.dto;

import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.AssemblyLine;
import it.euris.exam.teslabattery_bd.data.model.Formula;
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
public class FormulaDto implements Dto {

  private String id;
  private String name;
  private String assemblyLineId;

  @Override
  public Formula toModel() {
    return Formula.builder()
        .id(UT.toLong(id))
        .name(name)
        .assemblyLine(AssemblyLine.builder().id(UT.toLong(assemblyLineId)).build())
        .build();
  }
}
