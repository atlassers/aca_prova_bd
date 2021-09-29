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
import it.euris.exam.teslabattery_bd.data.dto.FormulaComponentDto;
import it.euris.exam.teslabattery_bd.service.FormulaComponentService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@RestController
@RequestMapping("/formulaConponents")
public class FormulaComponentController {

  @Autowired
  private FormulaComponentService formulaComponentService;
  
  @GetMapping("/v1")
  public List<FormulaComponentDto> getAll(){
    return formulaComponentService.getAll();
  }

  @GetMapping("/v1/{formulaId}/{componentId}")
  public FormulaComponentDto get(@PathVariable("formulaId") Long formulaId, @PathVariable("componentId") Long componentId) {
    return formulaComponentService.get(formulaId, componentId);
  }

  @PostMapping("/v1")
  public FormulaComponentDto add(@RequestBody FormulaComponentDto FormulaComponentDto) {
    return formulaComponentService.add(FormulaComponentDto);
  }

  @PutMapping("/v1")
  public FormulaComponentDto update(@RequestBody FormulaComponentDto FormulaComponentDto) {
    return formulaComponentService.update(FormulaComponentDto);
  }
  
  @DeleteMapping("/v1/{formulaId}/{componentId}")
  public Boolean delete(@PathVariable("formulaId") Long formulaId, @PathVariable("componentId") Long componentId) {
    return formulaComponentService.delete(formulaId, componentId);
  }
}
