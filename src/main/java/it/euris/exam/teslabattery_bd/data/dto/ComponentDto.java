package it.euris.exam.teslabattery_bd.data.dto;

import it.euris.exam.teslabattery_bd.data.archetype.Dto;
import it.euris.exam.teslabattery_bd.data.model.Component;
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
public class ComponentDto implements Dto {

  private String id;
  private String name;
  private String dangerous;

  @Override
  public Component toModel() {
    return Component.builder()
        .id(UT.toLong(id))
        .name(name)
        .dangerous(UT.toBoolean(dangerous))
        .build();
  }
}
