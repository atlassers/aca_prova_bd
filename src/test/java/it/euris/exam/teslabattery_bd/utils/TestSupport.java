package it.euris.exam.teslabattery_bd.utils;

import java.time.Instant;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import it.euris.exam.teslabattery_bd.data.model.AssemblyLine;
import it.euris.exam.teslabattery_bd.data.model.Component;
import it.euris.exam.teslabattery_bd.data.model.Formula;
import it.euris.exam.teslabattery_bd.data.model.FormulaComponent;
import it.euris.exam.teslabattery_bd.data.model.ProductionCycle;
import it.euris.exam.teslabattery_bd.data.model.Robot;
import it.euris.exam.teslabattery_bd.data.model.key.FormulaComponentKey;
import it.euris.exam.teslabattery_bd.enums.ComponentQuantityType;
import it.euris.exam.teslabattery_bd.enums.ProductionCycleStatus;
import it.euris.exam.teslabattery_bd.enums.RobotTask;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class TestSupport {

  public static Component createComponent(Long id) {
    return Component.builder()
        .id(id)
        .name("Alluminio")
        .dangerous(false)
        .build();
  }

  public static List<Component> createComponentList() {
    return List.of(createComponent(1L), createComponent(2L));
  }
  
  public static Robot createRobot(Long id) {
    return Robot.builder()
            .id(id)
            .task(RobotTask.MOVE)
            .position(1L)
            .model("SuperRobot3000")
        .build();
  }
  
  public static List<Robot> createRobotList() {
     return List.of(createRobot(1L), createRobot(2L));
  }
  
  public static ProductionCycle createProductionCycle(Long id) {
    Instant date = Instant.parse("2021-01-09T10:00:40Z");
    return ProductionCycle.builder()
        .id(id)
        .startDate(Instant.parse("2021-01-09T00:00:00Z"))
        .status(ProductionCycleStatus.COMPLETATO)
        .statusDate(date)
        .endDate(date)
        .build();
  }
  
  public static List<ProductionCycle> createProductionCycleList() {
    return List.of(createProductionCycle(1L), createProductionCycle(2L));
  }
  
  public static Formula createFormula(Long id) {
    return Formula.builder()
        .id(id)
        .name("AAA")
        .assemblyLine(createAssemblyLine(1L))
        .build();
  }
  
  public static List<Formula> createFormulaList() {
    return List.of(createFormula(1L), createFormula(2L));
  }
  
  public static AssemblyLine createAssemblyLine(Long id) {
    return AssemblyLine.builder()
        .id(id)
        .timeToComplete(100L)
        .build();
  }
  
  public static List<AssemblyLine> createAssemblyLineList() {
    return List.of(createAssemblyLine(1L), createAssemblyLine(2L));
  }
  
  public static FormulaComponent createFormulaComponent(FormulaComponentKey id) {
    return FormulaComponent.builder()
        .id(id)
        .quantity(30.0)
        .quantityType(ComponentQuantityType.GR)
        .formula(createFormula(id.getFormulaId()))
        .component(createComponent(id.getComponentId()))
        .build();
  }
  
  public static List<FormulaComponent> createFormulaComponentList() {
    return List.of(
        createFormulaComponent(new FormulaComponentKey(1L, 2L)),
        createFormulaComponent(new FormulaComponentKey(3L, 4L)));
  }
}
