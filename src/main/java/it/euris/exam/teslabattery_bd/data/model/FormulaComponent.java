package it.euris.exam.teslabattery_bd.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import it.euris.exam.teslabattery_bd.data.archetype.Model;
import it.euris.exam.teslabattery_bd.data.dto.FormulaComponentDto;
import it.euris.exam.teslabattery_bd.data.model.key.FormulaComponentKey;
import it.euris.exam.teslabattery_bd.enums.ComponentQuantityType;
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
@Entity
@Table(name = "formula_component")
@SQLDelete(sql = "UPDATE FormulaComponent SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class FormulaComponent implements Model {

  @EmbeddedId
  private FormulaComponentKey id;

  @ManyToOne
  @MapsId("formulaId")
  @JoinColumn(name = "formula_id", nullable = false)
  private Formula formula;
  
  @ManyToOne
  @MapsId("componentId")
  @JoinColumn(name = "component_id", nullable = false)
  private Component component;
  
  @Column(name = "quantity")
  private Double quantity;
  
  @Column(name = "quantity_type")
  @Enumerated(EnumType.STRING)
  private ComponentQuantityType quantityType;
  
  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;
  
  @Override
  public FormulaComponentDto toDto() {
    return FormulaComponentDto.builder()
        .formulaId(formula.getId().toString())
        .componentId(component.getId().toString())
        .quantity(UT.toString(quantity))
        .quantityType(UT.toString(quantityType))
        .build();
  }
}
