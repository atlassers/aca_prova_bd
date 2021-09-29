package it.euris.exam.teslabattery_bd.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import it.euris.exam.teslabattery_bd.data.dto.ComponentDto;
import it.euris.exam.teslabattery_bd.data.model.Component;
import it.euris.exam.teslabattery_bd.repository.ComponentRepository;
import it.euris.exam.teslabattery_bd.service.ComponentService;
import it.euris.exam.teslabattery_bd.utils.TestSupport;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class ComponentControllerTest {
  
  @Autowired
  ComponentService componentService;
  
  @MockBean
  ComponentRepository componentRepository;

  @Test
  void getAll() {
    List<Component> mockedComponents = TestSupport.createComponentList();
    when(componentRepository.findAll()).thenReturn(mockedComponents);
    
    List<ComponentDto> components = componentService.getAll();
    
    assertEquals(mockedComponents.size(), components.size());
    for(int i = 0; i < mockedComponents.size(); i++)
      assertEquals(mockedComponents.get(i).toDto(), components.get(i));
  }
  
  @Test
  void get() {
    final Long ID = 1L;
    Component mockedComponent = TestSupport.createComponent(ID);
    when(componentRepository.findById(ID)).thenReturn(Optional.of(mockedComponent));
  
    ComponentDto component = componentService.get(ID);
    
    assertEquals(mockedComponent.toDto(), component);
  }

  @Test
  void add() {
    Component componentToAdd = TestSupport.createComponent(null);
    Component componentToReturn = TestSupport.createComponent(11L);
    when(componentRepository.save(any())).thenReturn(componentToReturn);
    
    ComponentDto component = componentService.add(componentToAdd.toDto());
    
    assertEquals(componentToReturn.toDto(), component);
  }

  @Test
  void update() {
    Component componentToUpdate = TestSupport.createComponent(1L);
    Component componentToReturn = TestSupport.createComponent(11L);
    when(componentRepository.save(any())).thenReturn(componentToReturn);
    
    ComponentDto component = componentService.update(componentToUpdate.toDto());
    
    assertEquals(componentToReturn.toDto(), component); 
  }

  @Test
  void delete() {
    final Long ID = 1L;
    doNothing().when(componentRepository).deleteById(ID);
    when(componentRepository.findById(ID)).thenReturn(Optional.empty());
    
    Boolean deleted = componentService.delete(ID);
    
    assertTrue(deleted);
  }
}
