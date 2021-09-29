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
import it.euris.exam.teslabattery_bd.data.dto.ComponentDto;
import it.euris.exam.teslabattery_bd.service.ComponentService;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@RestController
@RequestMapping("/components")
public class ComponentController {

  @Autowired
  private ComponentService componentService;
  
  @GetMapping("/v1")
  public List<ComponentDto> getAll(){
    return componentService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ComponentDto get(@PathVariable("id") Long id) {
    return componentService.get(id);
  }

  @PostMapping("/v1")
  public ComponentDto add(@RequestBody ComponentDto componentDto) {
    return componentService.add(componentDto);
  }

  @PutMapping("/v1")
  public ComponentDto update(@RequestBody ComponentDto componentDto) {
    return componentService.update(componentDto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return componentService.delete(id);
  }
}
