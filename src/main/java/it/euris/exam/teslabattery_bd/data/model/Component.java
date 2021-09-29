package it.euris.exam.teslabattery_bd.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import it.euris.exam.teslabattery_bd.data.archetype.Model;
import it.euris.exam.teslabattery_bd.data.dto.ComponentDto;
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
@Table(name = "component")
@SQLDelete(sql = "UPDATE Component SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Component implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "dangerous")
  private Boolean dangerous;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @Override
  public ComponentDto toDto() {
    return ComponentDto.builder()
        .id(UT.toString(id))
        .name(name)
        .dangerous(UT.toString(dangerous))
        .build();
  }

}
