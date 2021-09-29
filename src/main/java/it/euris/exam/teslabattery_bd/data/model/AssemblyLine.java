package it.euris.exam.teslabattery_bd.data.model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Model;
import it.euris.exam.teslabattery_bd.data.dto.AssemblyLineDto;
import it.euris.exam.teslabattery_bd.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "assembly_line")
@SQLDelete(sql = "UPDATE AssemblyLine SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class AssemblyLine implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "time_to_complete")
  private Long timeToComplete;
  
  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;
  
  @OneToOne(mappedBy = "assemblyLine")
  @JsonIgnore
  Formula formula;
  
  @OneToMany(mappedBy = "assemblyLine")
  @Builder.Default
  @JsonIgnore
  List<ProductionCycle> productionCycle = new ArrayList<ProductionCycle>();
  
  @ManyToMany
  @JoinTable(
        name = "assembly_line_robot",
        joinColumns = @JoinColumn(name = "assembly_line_id"),
        inverseJoinColumns  = @JoinColumn(name = "robot_id")
      )
  @Builder.Default
  @JsonIgnore
  private List<Robot> robots = new ArrayList<Robot>();
  
  @Override
  public AssemblyLineDto toDto() {
    return AssemblyLineDto.builder()
        .id(UT.toString(id))
        .timeToComplete(UT.toString(timeToComplete))
        .build();
  }
}
