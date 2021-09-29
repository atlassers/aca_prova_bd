package it.euris.exam.teslabattery_bd.service;

import java.util.List;
import it.euris.exam.teslabattery_bd.data.dto.FormulaComponentDto;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface FormulaComponentService {

  public List<FormulaComponentDto> getAll();
  public FormulaComponentDto get(Long formulaId, Long componentId);
  public FormulaComponentDto add(FormulaComponentDto formulaFormulaComponentDto);
  public FormulaComponentDto update(FormulaComponentDto formulaFormulaComponentDto);
  public Boolean delete(Long formulaId, Long componentId);
}
