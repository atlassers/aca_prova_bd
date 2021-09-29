package it.euris.exam.teslabattery_bd.service;

import java.util.List;
import it.euris.exam.teslabattery_bd.data.dto.FormulaDto;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface FormulaService {

  public List<FormulaDto> getAll();
  public FormulaDto get(Long id);
  public FormulaDto add(FormulaDto formulaDto);
  public FormulaDto update(FormulaDto formulaDto);
  public Boolean delete(Long id);
}
