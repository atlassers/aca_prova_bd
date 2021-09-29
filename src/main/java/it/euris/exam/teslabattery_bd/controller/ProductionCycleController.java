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
import it.euris.exam.teslabattery_bd.data.dto.ProductionCycleDto;
import it.euris.exam.teslabattery_bd.service.ProductionCycleService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@RestController
@RequestMapping("/productionCycles")
public class ProductionCycleController {

  @Autowired
  private ProductionCycleService productionCycleService;
  
  @GetMapping("/v1")
  public List<ProductionCycleDto> getAll(){
    return productionCycleService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ProductionCycleDto get(@PathVariable("id") Long id) {
    return productionCycleService.get(id);
  }

  @PostMapping("/v1")
  public ProductionCycleDto add(@RequestBody ProductionCycleDto productionCycleDto) {
    return productionCycleService.add(productionCycleDto);
  }

  @PutMapping("/v1")
  public ProductionCycleDto update(@RequestBody ProductionCycleDto productionCycleDto) {
    return productionCycleService.update(productionCycleDto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return productionCycleService.delete(id);
  }
}
