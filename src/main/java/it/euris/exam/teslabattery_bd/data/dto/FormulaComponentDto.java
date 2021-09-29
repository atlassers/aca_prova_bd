package it.euris.exam.teslabattery_bd.data.dto;

import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.Component;
import it.euris.exam.teslabattery_bd.data.model.Formula;
import it.euris.exam.teslabattery_bd.data.model.FormulaComponent;
import it.euris.exam.teslabattery_bd.data.model.key.FormulaComponentKey;
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
public class FormulaComponentDto implements Dto {

  private String formulaId;
  private String componentId;
  private String quantity;
  private String quantityType;

  @Override
  public FormulaComponent toModel() {
    return FormulaComponent.builder()
        .id(new FormulaComponentKey(UT.toLong(formulaId), UT.toLong(componentId)))
        .formula(Formula.builder().id(UT.toLong(formulaId)).build())
        .component(Component.builder().id(UT.toLong(componentId)).build())
        .quantity(UT.toDouble(quantity))
        .quantityType(UT.toComponentQantityType(quantityType))
        .build();
  }
}
