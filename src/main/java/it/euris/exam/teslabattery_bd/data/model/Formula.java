package it.euris.exam.teslabattery_bd.data.model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Model;
import it.euris.exam.teslabattery_bd.data.dto.FormulaDto;
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
@Table(name = "formula")
@SQLDelete(sql = "UPDATE Formula SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Formula implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @OneToMany(mappedBy = "formula")
  @Builder.Default
  @JsonIgnore
  private Set<FormulaComponent> formulaComponents = new HashSet<FormulaComponent>();   
  
  @OneToOne
  @JoinColumn(name = "assembly_line_id", referencedColumnName = "id", nullable = false)
  @JsonIgnore
  private AssemblyLine assemblyLine;
  
  @Override
  public FormulaDto toDto() {
    return FormulaDto.builder()
        .id(UT.toString(id))
        .name(name)
        .build();
  }
}
