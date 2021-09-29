package it.euris.exam.teslabattery_bd.utils;

import java.time.Instant;
import it.euris.exam.teslabattery_bd.enums.ComponentQuantityType;
import it.euris.exam.teslabattery_bd.enums.ProductionCycleStatus;
import it.euris.exam.teslabattery_bd.enums.RobotTask;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public class UT {

  public static String toString(Object o) {
    return o == null ? null : o.toString();
  }

  public static Long toLong(String s) {
    return s == null ? null : Long.parseLong(s);
  }

  public static Double toDouble(String s) {
    return s == null ? null : Double.parseDouble(s);
  }

  public static Boolean toBoolean(String s) {
    return s == null ? null : Boolean.valueOf(s);
  }

  public static ComponentQuantityType toComponentQantityType(String s) {
    if (s == null)
      return null;
    for (ComponentQuantityType type : ComponentQuantityType.values()) {
      if (type.name().equals(s))
        return type;
    }
    return null;
  }

  public static RobotTask toRobotTask(String s) {
    if (s == null)
      return null;
    for (RobotTask type : RobotTask.values()) {
      if (type.name().equals(s))
        return type;
    }
    return null;
  }
  
  public static ProductionCycleStatus toProductionCycleStatus(String s) {
    if (s == null)
      return null;
    for (ProductionCycleStatus type : ProductionCycleStatus.values()) {
      if (type.name().equals(s))
        return type;
    }
    return null;
  }

  public static Instant toInstant(String s) {
    return s == null ? null : Instant.parse(s);
  }
}
