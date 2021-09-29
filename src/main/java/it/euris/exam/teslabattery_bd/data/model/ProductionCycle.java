package it.euris.exam.teslabattery_bd.data.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.exam.teslabattery_bd.data.archetype.Model;
import it.euris.exam.teslabattery_bd.data.dto.ProductionCycleDto;
import it.euris.exam.teslabattery_bd.enums.ProductionCycleStatus;
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
@Table(name = "production_cycle")
@SQLDelete(sql = "UPDATE ProductionCycle SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class ProductionCycle implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "start_date")
  private Instant startDate;
  
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private ProductionCycleStatus status;
  
  @Column(name = "status_date")
  private Instant statusDate;
  
  @Column(name = "end_date")
  private Instant endDate;
  
  @ManyToOne
  @JoinColumn(name = "assembly_line_id", nullable = false)
  @JsonIgnore
  private AssemblyLine assemblyLine;
  
  @Override
  public ProductionCycleDto toDto() {
    return ProductionCycleDto.builder()
        .id(UT.toString(id))
        .startDate(UT.toString(startDate))
        .status(UT.toString(status))
        .statusDate(UT.toString(statusDate))
        .endDate(UT.toString(endDate))
        .build();
  }
}
