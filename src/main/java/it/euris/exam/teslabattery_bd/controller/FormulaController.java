package it.euris.exam.teslabattery_bd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.exam.teslabattery_bd.data.dto.FormulaDto;
import it.euris.exam.teslabattery_bd.service.FormulaService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@RestController
@RequestMapping("/formulas")
public class FormulaController {

  @Autowired
  private FormulaService formulaService;
  
  @GetMapping("/v1")
  public List<FormulaDto> getAll(){
    return formulaService.getAll();
  }

  @GetMapping("/v1/{id}")
  public FormulaDto get(@PathVariable("id") Long id) {
    return formulaService.get(id);
  }

  @PostMapping("/v1")
  public FormulaDto add(@RequestBody FormulaDto formulaDto) {
    return formulaService.add(formulaDto);
  }

  @PutMapping("/v1")
  public FormulaDto update(@RequestBody FormulaDto formulaDto) {
    return formulaService.update(formulaDto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return formulaService.delete(id);
  }
}
