package it.euris.exam.teslabattery_bd.data.model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Model;
import it.euris.exam.teslabattery_bd.data.dto.RobotDto;
import it.euris.exam.teslabattery_bd.enums.RobotTask;
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
@Table(name = "robot")
@SQLDelete(sql = "UPDATE Robot SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Robot implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "task")
  @Enumerated(EnumType.STRING)
  private RobotTask task;
  
  @Column(name = "position")
  private Long position;
  
  @Column(name = "model")
  private String model;
  
  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;
  
  @ManyToMany(mappedBy = "robots")
  @Builder.Default
  @JsonIgnore
  private Set<AssemblyLine> assemblyLines = new HashSet<AssemblyLine>();
  
  @Override
  public RobotDto toDto() {
    return RobotDto.builder()
        .id(UT.toString(id))
        .task(UT.toString(task))
        .position(UT.toString(position))
        .model(UT.toString(model))
        .build();
  }
}
