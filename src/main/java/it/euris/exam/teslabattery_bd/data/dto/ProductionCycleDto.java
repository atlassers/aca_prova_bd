package it.euris.exam.teslabattery_bd.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.ProductionCycle;
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
public class ProductionCycleDto implements Dto {

  private String id;
  private String startDate;
  private String status;
  private String statusDate;
  private String endDate;
  
  @JsonIgnore
  private AssemblyLineDto assemblyLine;

  @Override
  public ProductionCycle toModel() {
    return ProductionCycle.builder()
        .id(UT.toLong(id))
        .startDate(UT.toInstant(startDate))
        .status(UT.toProductionCycleStatus(status))
        .statusDate(UT.toInstant(statusDate))
        .endDate(UT.toInstant(endDate))
        .assemblyLine(assemblyLine == null ? null : assemblyLine.toModel())
        .build();
  }
}
