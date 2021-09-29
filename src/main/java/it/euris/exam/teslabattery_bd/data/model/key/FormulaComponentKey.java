package it.euris.exam.teslabattery_bd.data.model.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FormulaComponentKey implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Column(name = "formula_id")
  Long formulaId;
  
  @Column(name = "component_id")
  Long componentId;
}
